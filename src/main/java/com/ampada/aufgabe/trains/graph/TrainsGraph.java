package com.ampada.aufgabe.trains.graph;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
@Component
public class TrainsGraph {

    @Value("${trains.graph}")
    private String graphPattern;

    public static final DirectedGraphImpl directedGraph = new DirectedGraphImpl<String>();

    @PostConstruct
    public void init() {
        final String[] nodes = graphPattern.split(",");
        for (final String vertexEdgePair : nodes) {
            addNodes(directedGraph, vertexEdgePair);
        }
    }

    private void addNodes(final Graph<String> graph, final String vertexEdgePair) {
        final String trimmedPair = vertexEdgePair.trim();
        final String from = String.valueOf(trimmedPair.charAt(0));
        final String to = String.valueOf(trimmedPair.charAt(1));
        final int weight = Integer.valueOf(trimmedPair.substring(2));
        graph.addVertex(from);
        graph.addVertex(to);
        graph.addEdge(from, to, weight);
    }
}
