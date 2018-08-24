package com.ampada.aufgabe.trains.criteria;


import com.ampada.aufgabe.trains.graph.Path;

public class Contains<V> implements PathFilter<V> {
    private final Path<V> objectivePath;

    public Contains(final Path<V> objectivePath) {
        this.objectivePath = objectivePath;
    }

    @Override
    public boolean passFilter(final Path<V> path) {
        return objectivePath.startsWith(path);
    }

}
