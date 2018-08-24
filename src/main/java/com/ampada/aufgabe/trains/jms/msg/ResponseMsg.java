package com.ampada.aufgabe.trains.jms.msg;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by khayatzadeh on 8/22/2018.
 */

public class ResponseMsg implements Serializable {

    private static final long serialVersionUID = 6413807387494281041L;
    private Map<String, String> resultMap = new LinkedHashMap<>();

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }
}
