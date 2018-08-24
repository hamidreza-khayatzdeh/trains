package com.ampada.aufgabe.trains.graph;

import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.criteria.PathFilter;

import java.util.List;
import java.util.Set;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public interface Graph<V> {

    boolean addEdge(V from, V to, int weight);

    boolean addVertex(V vertex);

    List<Path<V>> getAllPaths(V startingNode, V endingNode, PathFilter<V> filter) throws NoSuchRouteException;

}
