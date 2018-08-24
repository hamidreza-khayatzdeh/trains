package com.ampada.aufgabe.trains.executor;

import com.ampada.aufgabe.trains.dto.ResponseDto;
import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
@Component
public class MaxDistanceExecutor extends AbstractExecutor implements TrainExecutor {

    @Autowired
    private TrainService trainService;

    @Override
    public TrainExecutorType getExecutorType() {
        return TrainExecutorType.MAX_DISTANCE;
    }

    @Override
    public ResponseDto execute(final String requestContent) throws NoSuchRouteException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMsg(requestContent);
        final String routeLine = requestContent.substring(14);
        final String[] nodes = routeLine.split("-");
        try {
            int stops = Integer.valueOf(nodes[2]);
            int result = trainService.calculateNumberOfPathsWithMaxWeight(nodes[0], nodes[1], stops);
            responseDto.setResult(String.valueOf(result));
        } catch (NoSuchRouteException e) {
            responseDto.setResult(e.getMessage());
        }
        return responseDto;
    }

}
