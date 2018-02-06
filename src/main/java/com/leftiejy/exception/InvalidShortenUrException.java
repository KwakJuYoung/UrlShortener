package com.leftiejy.exception;

public class InvalidShortenUrException extends Exception {
    public InvalidShortenUrException(String message) {
        super(String.format("Shorten Path[%s] is invalid", message));
    }
}
