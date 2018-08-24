package com.ampada.aufgabe.trains.graph;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public interface Edge<V> {
    V getStartingVertex();

    V getEndingVertex();

    int getWeight();
}
