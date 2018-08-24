package com.ampada.aufgabe.trains.criteria;


import com.ampada.aufgabe.trains.graph.Path;

public class MaxHops<V> implements PathFilter<V> {
    private final int maxHops;

    public MaxHops(final int maxHops) {
        super();
        this.maxHops = maxHops;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return path.getNumberOfHops() <= maxHops;
    }

}
