package com.ampada.aufgabe.trains.criteria;


import com.ampada.aufgabe.trains.graph.Path;

public class Weight<V> implements PathFilter<V> {
    private final int maxWeight;

    public Weight(final int maxWeight) {
        super();
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return path.getPathTotalWeight() < maxWeight;
    }

}
