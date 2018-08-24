package com.ampada.aufgabe.trains.util;

import com.ampada.aufgabe.trains.executor.TrainExecutorType;

/**
 * Created by khayatzadeh on 8/23/2018.
 */
public class TrainUtil {

    private static final String DISTANCE_REGEX = "DISTANCE:\\s\\D-\\D(-\\D)*";
    private static final String MAX_STOPS_REGEX = "MAX_STOPS:\\s\\D-\\D-\\d";
    private static final String EXACT_STOPS_REGEX = "EXACT_STOPS:\\s\\D-\\D-\\d";
    private static final String MAX_DISTANCE_REGEX = "MAX_DISTANCE:\\s\\D-\\D-\\d*";
    private static final String SHORTEST_REGEX = "SHORTEST:\\s\\D-\\D";

    public static TrainExecutorType getExecutorType(final String msg) {
        if (msg.matches(SHORTEST_REGEX)) {
            return TrainExecutorType.SHORTEST;
        } else if (msg.matches(DISTANCE_REGEX)) {
            return TrainExecutorType.DISTANCE;
        } else if (msg.matches(MAX_STOPS_REGEX)) {
            return TrainExecutorType.MAX_STOPS;
        } else if (msg.matches(EXACT_STOPS_REGEX)) {
            return TrainExecutorType.EXACT_STOPS;
        } else if (msg.matches(MAX_DISTANCE_REGEX)) {
            return TrainExecutorType.MAX_DISTANCE;
        } else {
            throw new IllegalArgumentException("invalid Message Pattern");
        }
    }
}
