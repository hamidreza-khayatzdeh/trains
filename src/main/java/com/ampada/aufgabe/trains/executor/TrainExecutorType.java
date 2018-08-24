package com.ampada.aufgabe.trains.executor;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public enum TrainExecutorType {
    DISTANCE('d'),
    SHORTEST('s'),
    MAX_STOPS('m'),
    EXACT_STOPS('e'),
    MAX_DISTANCE('x');

    private char value;

    TrainExecutorType(char val) {
        this.value = val;
    }

    public char getValue() {
        return value;
    }
}
