package com.ampada.aufgabe.trains.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by khayatzadeh on 8/23/2018.
 */
public abstract class AbstractExecutor {

    protected List<String> getIntermediateList(final String[] nodes) {
        final List<String> intermediateList = new ArrayList<String>();
        intermediateList.addAll(Arrays.asList(nodes).subList(1, nodes.length - 1));
        return intermediateList;
    }

    protected String[] getNodesForDistanceAndDuration(String requestContent) {
        final String routeLine = requestContent.substring(10);
        return routeLine.split("-");
    }
}
