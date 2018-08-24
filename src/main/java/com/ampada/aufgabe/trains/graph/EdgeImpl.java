package com.ampada.aufgabe.trains.graph;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public class EdgeImpl<V> implements Edge<V> {
    private final V startingVertex;
    private final V endingVertex;
    private final int weight;

    private EdgeImpl(final V startingVertex, final V endingVertex, final int weight) {
        super();
        this.startingVertex = startingVertex;
        this.endingVertex = endingVertex;
        this.weight = weight;
    }

    public static <V> Edge<V> getWeightedEdge(final V startingVertex, final V endingVertex, final int weight) {
        return new EdgeImpl<V>(startingVertex, endingVertex, weight);
    }

    @Override
    public V getStartingVertex() {
        return startingVertex;
    }

    @Override
    public V getEndingVertex() {
        return endingVertex;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + startingVertex.toString() + ", " + endingVertex.toString() + "); ";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (endingVertex == null ? 0 : endingVertex.hashCode());
        result = prime * result + (startingVertex == null ? 0 : startingVertex.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EdgeImpl other = (EdgeImpl) obj;
        if (endingVertex == null) {
            if (other.endingVertex != null) {
                return false;
            }
        } else if (!endingVertex.equals(other.endingVertex)) {
            return false;
        }
        if (startingVertex == null) {
            if (other.startingVertex != null) {
                return false;
            }
        } else if (!startingVertex.equals(other.startingVertex)) {
            return false;
        }
        return true;
    }

}
