package com.ampada.aufgabe.trains.jms.msg;

import java.io.Serializable;
import java.util.List;

/**
 * Created by khayatzadeh on 8/22/2018.
 */

public class RequestMsg implements Serializable {

    private static final long serialVersionUID = -6813291371188754313L;

    private List<String> requests;

    public List<String> getRequests() {
        return requests;
    }

    public void setRequests(List<String> requests) {
        this.requests = requests;
    }
}
