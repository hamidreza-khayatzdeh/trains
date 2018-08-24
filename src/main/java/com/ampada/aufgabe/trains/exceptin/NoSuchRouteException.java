package com.ampada.aufgabe.trains.exceptin;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public class NoSuchRouteException extends Exception {

    private static final long serialVersionUID = 890027920431290962L;

    public NoSuchRouteException(final String startingVertex, final String endingVertex) {
        super("No route exists between " + startingVertex + " and " + endingVertex);
    }
}
