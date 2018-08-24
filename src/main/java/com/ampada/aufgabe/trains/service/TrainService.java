package com.ampada.aufgabe.trains.service;

import com.ampada.aufgabe.trains.exceptin.NoSuchRouteException;
import com.ampada.aufgabe.trains.graph.Graph;

import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public interface TrainService {

    int calculateDistance(String startingCity, String destinationCity, List<String> intermediateCities) throws NoSuchRouteException;

    int calculateNumberOfPathsWithMaxStops(String startingCity, String destinationCity, int stops) throws NoSuchRouteException;

    int calculateNumberOfPathsWithMaxWeight(String startingCity, String destinationCity, int weight) throws NoSuchRouteException;

    int calculateNumberOfPathsWithExactStops(String startingCity, String destinationCity, int stops) throws NoSuchRouteException;

    int calculateShortestDistance(String startingCity, String destinationCity) throws NoSuchRouteException;

}
