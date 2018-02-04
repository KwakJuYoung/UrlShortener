package com.leftiejy.exception;

public class UrlNotFoundException extends Exception {
    public UrlNotFoundException(String message) {
        super(String.format("Shorten Path[%s] not found", message));
    }
}
