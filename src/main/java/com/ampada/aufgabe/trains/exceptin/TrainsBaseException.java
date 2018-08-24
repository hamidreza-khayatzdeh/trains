package com.ampada.aufgabe.trains.exceptin;

/**
 * Created by khayatzadeh on 8/22/2018.
 */
public class TrainsBaseException extends Exception {
    private static final long serialVersionUID = 4749349555917498159L;

    public TrainsBaseException() {
    }

    public TrainsBaseException(String message) {
        super(message);
    }

    public TrainsBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainsBaseException(Throwable cause) {
        super(cause);
    }

    public TrainsBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
