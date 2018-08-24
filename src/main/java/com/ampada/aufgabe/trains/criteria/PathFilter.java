package com.ampada.aufgabe.trains.criteria;


import com.ampada.aufgabe.trains.graph.Path;

public interface PathFilter<V> {

    boolean passFilter(final Path<V> path);

}
