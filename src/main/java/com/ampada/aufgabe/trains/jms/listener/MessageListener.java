package com.ampada.aufgabe.trains.jms.listener;

import com.ampada.aufgabe.trains.dto.ResponseDto;
import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.executor.TrainExecutorType;
import com.ampada.aufgabe.trains.jms.dispatcher.MessageDispatcher;
import com.ampada.aufgabe.trains.jms.msg.RequestMsg;
import com.ampada.aufgabe.trains.jms.msg.ResponseMsg;
import com.ampada.aufgabe.trains.util.TrainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
@Component
public class MessageListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageDispatcher messageDispatcher;

    @JmsListener(destination = "requestReceiver", containerFactory = "myFactory")
    public void receiveMessage(RequestMsg requestMsg) throws NoSuchRouteException {
        ResponseMsg responseMsg = new ResponseMsg();
        List<String> requests = requestMsg.getRequests();
        for (String request : requests) {
            TrainExecutorType trainExecutorType = TrainUtil.getExecutorType(request);
            ResponseDto responseDto = messageDispatcher.dispatchCommand(trainExecutorType, request);
            responseMsg.getResultMap().put(responseDto.getMsg(), String.valueOf(responseDto.getResult()));
        }
        jmsTemplate.convertAndSend("responseSender", responseMsg);
    }
}
