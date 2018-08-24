package com.ampada.aufgabe.trains;

import com.ampada.aufgabe.trains.executor.TrainExecutorType;
import com.ampada.aufgabe.trains.jms.msg.RequestMsg;
import com.ampada.aufgabe.trains.jms.msg.ResponseMsg;
import com.ampada.aufgabe.trains.util.TrainUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrainsApplication {

    private static Logger logger = LoggerFactory.getLogger(TrainsApplication.class);

    public static void main(String[] args) throws Exception {
        logger.info("The Train Application is starting!");
        ConfigurableApplicationContext context = SpringApplication.run(TrainsApplication.class, args);
        DefaultMessageRunner.sendDefaultMsg(context);
    }
}
