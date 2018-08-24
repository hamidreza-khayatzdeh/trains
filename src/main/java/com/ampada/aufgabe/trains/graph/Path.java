package com.ampada.aufgabe.trains.graph;

import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */

public interface Path<V> extends Comparable<Path<V>> {

    void addEdge(Edge<V> edge);

    int getPathTotalWeight();

    int getNumberOfHops();

    V getLastNode();

    void removeLastEdge();

    List<Edge<V>> getEdgeList();

    boolean hasRepeatedEdges();

    boolean startsWith(Path<V> otherPath);

}