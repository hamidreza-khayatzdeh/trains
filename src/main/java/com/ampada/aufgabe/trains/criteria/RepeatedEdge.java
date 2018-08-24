package com.ampada.aufgabe.trains.criteria;


import com.ampada.aufgabe.trains.graph.Path;

public class RepeatedEdge<V> implements PathFilter<V> {

    @Override
    public boolean passFilter(final Path<V> path) {
        return !path.hasRepeatedEdges();
    }
}
