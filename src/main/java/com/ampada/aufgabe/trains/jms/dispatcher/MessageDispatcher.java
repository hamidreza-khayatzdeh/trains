package com.ampada.aufgabe.trains.jms.dispatcher;

import com.ampada.aufgabe.trains.executor.TrainExecutor;
import com.ampada.aufgabe.trains.executor.TrainExecutorType;
import com.ampada.aufgabe.trains.dto.ResponseDto;
import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
@Component
public class MessageDispatcher implements ApplicationContextAware {

    private Map<TrainExecutorType, TrainExecutor> commandExecutorMap;

    public ResponseDto dispatchCommand(TrainExecutorType trainExecutorType, String requestContent) throws NoSuchRouteException {
        return commandExecutorMap.get(trainExecutorType).execute(requestContent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        commandExecutorMap = new ConcurrentHashMap<>();
        Map<String, TrainExecutor> commandExecutor = applicationContext.getBeansOfType(TrainExecutor.class);
        for (TrainExecutor trainExecutor : commandExecutor.values()) {
            commandExecutorMap.put(trainExecutor.getExecutorType(), trainExecutor);
        }
    }
}
