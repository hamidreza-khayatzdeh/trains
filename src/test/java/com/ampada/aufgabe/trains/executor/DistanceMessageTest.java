package com.ampada.aufgabe.trains.executor;

import com.ampada.aufgabe.trains.TrainsApplicationTests;
import com.ampada.aufgabe.trains.jms.msg.RequestMsg;
import com.ampada.aufgabe.trains.jms.msg.ResponseMsg;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by khayatzadeh on 8/22/2018.
 */

public class DistanceMessageTest extends TrainsApplicationTests {

    private Logger logger = LoggerFactory.getLogger(DistanceMessageTest.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void executorsTest() {
        logger.info("Sending a composite message.");
        RequestMsg message = new RequestMsg();
        List<String> requests = new ArrayList<>();
        requests.add("DISTANCE: A-B-C");
        requests.add("DISTANCE: A-D");
        requests.add("DISTANCE: A-D-C");
        requests.add("DISTANCE: A-E-B-C-D");
        requests.add("DISTANCE: A-E-D");
        requests.add("MAX_STOPS: C-C-3");
        requests.add("EXACT_STOPS: A-C-4");
        requests.add("SHORTEST: A-C");
        requests.add("SHORTEST: B-B");
        requests.add("MAX_DISTANCE: C-C-30");
        message.setRequests(requests);
        jmsTemplate.convertAndSend("requestReceiver", message);
        this.jmsTemplate.setReceiveTimeout(100000);
        ResponseMsg response = (ResponseMsg) jmsTemplate.receiveAndConvert("responseSender");
        assertThat(response).isNotNull();
        response.getResultMap().forEach((k, v) -> System.out.println(String.format("%s%s", k, " = " + v)));

    }
}
