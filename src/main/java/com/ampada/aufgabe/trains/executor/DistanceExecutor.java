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
public class DistanceExecutor extends AbstractExecutor implements TrainExecutor {

    @Autowired
    private TrainService trainService;

    @Override
    public TrainExecutorType getExecutorType() {
        return TrainExecutorType.DISTANCE;
    }

    @Override
    public ResponseDto execute(final String requestContent) throws NoSuchRouteException {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMsg(requestContent);
        final String[] nodes = getNodesForDistanceAndDuration(requestContent);
        try {
            int result = trainService.calculateDistance(nodes[0], nodes[nodes.length - 1], getIntermediateList(nodes));
            responseDto.setResult(String.valueOf(result));
        } catch (NoSuchRouteException e) {
            responseDto.setResult(e.getMessage());
        }
        return responseDto;
    }

}
