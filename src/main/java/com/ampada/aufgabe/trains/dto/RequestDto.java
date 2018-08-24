package com.ampada.aufgabe.trains.dto;

import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public class RequestDto {

    private String startingCity;
    private String destinationCity;
    private List<String> intermediateCities;

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public List<String> getIntermediateCities() {
        return intermediateCities;
    }

    public void setIntermediateCities(List<String> intermediateCities) {
        this.intermediateCities = intermediateCities;
    }
}
