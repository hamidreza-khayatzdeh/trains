package com.ampada.aufgabe.trains.executor;

import com.ampada.aufgabe.trains.dto.ResponseDto;
import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public interface TrainExecutor {

    TrainExecutorType getExecutorType();

    ResponseDto execute(final String requestContent) throws NoSuchRouteException;
}
