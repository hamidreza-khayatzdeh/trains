package com.ampada.aufgabe.trains.graph;

import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.criteria.PathFilter;

import java.util.*;

/**
 * Created by khayatzadeh on 8/22/2018.
 */

public class DirectedGraphImpl<V> implements Graph<V> {
    private final Map<V, Set<Edge<V>>> edges = new HashMap<>();

    @Override
    public boolean addVertex(final V vertex) {
        assertVertexNotNull(vertex);
        if (!edges.containsKey(vertex)) {
            edges.put(vertex, new LinkedHashSet<>());
            return true;
        }
        return false;
    }

    private void assertVertexNotNull(final V vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex can not be null");
        }
    }

    @Override
    public boolean addEdge(final V from, final V to, final int weight) {
        assertVertexExists(from);
        assertVertexExists(to);

        final Edge<V> newEdge = EdgeImpl.getWeightedEdge(from, to, weight);

        final Set<Edge<V>> sourceEdges = edges.get(from);
        if (sourceEdges.contains(newEdge)) {
            sourceEdges.remove(newEdge);
        }
        return edges.get(from).add(newEdge);
    }

    private void assertVertexExists(final V vertex) {
        if (!edges.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex.toString() + " does not exist");
        }
    }

    @Override
    public List<Path<V>> getAllPaths(final V startingNode, final V endingNode, final PathFilter<V> filter) throws NoSuchRouteException {
        assertVertexExists(startingNode);
        assertVertexExists(endingNode);

        final List<Path<V>> paths = new ArrayList<>();
        for (final Edge<V> each : edges.get(startingNode)) {
            final Path<V> path = PathImpl.emptyPath();
            path.addEdge(each);
            paths.addAll(search(path, filter, endingNode));
        }

        if (paths.isEmpty()) {
            throw new NoSuchRouteException(startingNode.toString(), endingNode.toString());
        }
        return paths;
    }

    private List<Path<V>> search(final Path<V> path, final PathFilter<V> filter, final V end) {
        final List<Path<V>> paths = new ArrayList<>();
        if (filter.passFilter(path)) {
            if (hasReachedGoal(path, end)) {
                paths.add(PathImpl.copyPath(path));
            }
            for (final Edge<V> each : edges.get(path.getLastNode())) {
                path.addEdge(each);
                paths.addAll(search(path, filter, end));
            }

        }
        path.removeLastEdge();
        return paths;
    }

    private boolean hasReachedGoal(final Path<V> path, final V end) {
        return path.getLastNode().equals(end);
    }

}
