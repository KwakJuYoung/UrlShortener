package com.leftiejy.exception;

/**
 * Created by leftiejy on 2018. 2. 4..
 */
public class UrlNotFoundException extends Exception {
    public UrlNotFoundException(String message) {
        super(String.format("Shorten Path[%s] not found", message));
    }
}
