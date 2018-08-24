package com.ampada.aufgabe.trains.service;

import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.criteria.*;
import com.ampada.aufgabe.trains.graph.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
@Component
public final class TrainServiceImpl implements TrainService {

    @Override
    public int calculateNumberOfPathsWithExactStops(final String startingCity, final String destinationCity, final int stops) throws NoSuchRouteException {
        final List<Path<String>> paths = TrainsGraph.directedGraph.getAllPaths(startingCity, destinationCity, new MaxHops<String>(stops));
        final List<Path<String>> exactPaths = new ArrayList<>();
        for (final Path<String> each : paths) {
            if (each.getNumberOfHops() == stops) {
                exactPaths.add(each);
            }
        }
        return exactPaths.size();
    }

    @Override
    public int calculateNumberOfPathsWithMaxStops(final String startingCity, final String destinationCity, final int stops) throws NoSuchRouteException {
        return TrainsGraph.directedGraph.getAllPaths(startingCity, destinationCity, new MaxHops<String>(stops)).size();
    }

    @Override
    public int calculateNumberOfPathsWithMaxWeight(final String startingCity, final String destinationCity, final int weight) throws NoSuchRouteException {
        return TrainsGraph.directedGraph.getAllPaths(startingCity, destinationCity, new Weight<String>(weight)).size();
    }

    @Override
    public int calculateShortestDistance(final String startingCity, final String destinationCity) throws NoSuchRouteException {
        final List<Path<String>> allPaths = TrainsGraph.directedGraph.getAllPaths(startingCity, destinationCity,
                new RepeatedEdge<String>());
        return Collections.min(allPaths).getPathTotalWeight();
    }

    @Override
    public int calculateDistance(final String startingCity, final String destinationCity, final List<String> intermediateNodes) throws NoSuchRouteException {
        final Path<String> objectivePath = createPath(startingCity, destinationCity, intermediateNodes);
        final List<Path<String>> allPaths = TrainsGraph.directedGraph.getAllPaths(startingCity, destinationCity, new Contains<String>(
                objectivePath));
        return allPaths.get(0).getPathTotalWeight();
    }

    private Path<String> createPath(final String from, final String to, final List<String> intermediateNodes) {
        final Path<String> resultingPath = PathImpl.emptyPath();
        String currentNode = from;
        if (intermediateNodes != null) {
            for (final String eachIntermediate : intermediateNodes) {
                resultingPath.addEdge(EdgeImpl.getWeightedEdge(currentNode, eachIntermediate, 0));
                currentNode = eachIntermediate;
            }
        }
        resultingPath.addEdge(EdgeImpl.getWeightedEdge(currentNode, to, 0));
        return resultingPath;
    }

}
