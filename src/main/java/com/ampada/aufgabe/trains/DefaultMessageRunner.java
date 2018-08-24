package com.ampada.aufgabe.trains;

import com.ampada.aufgabe.trains.jms.msg.RequestMsg;
import com.ampada.aufgabe.trains.jms.msg.ResponseMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khayatzadeh on 8/24/2018.
 */
class DefaultMessageRunner {

    static void sendDefaultMsg(ApplicationContext context) {
        Boolean runDefaultMsg = Boolean.valueOf(context.getEnvironment().getProperty("runDefaultMsg"));
        if (runDefaultMsg) {
            try {
                File inputFile = new File(TrainsApplication.class.getResource("/default-request.txt").toURI());
                final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                RequestMsg message = new RequestMsg();
                List<String> requests = new ArrayList<>();
                while (reader.ready())
                    requests.add(reader.readLine());
                message.setRequests(requests);
                JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
                jmsTemplate.convertAndSend("requestReceiver", message);
                jmsTemplate.setReceiveTimeout(100000);
                ResponseMsg response = (ResponseMsg) jmsTemplate.receiveAndConvert("responseSender");
                response.getResultMap().forEach((k, v) -> System.out.println(String.format("%s%s", k, " = " + v)));
                reader.close();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
