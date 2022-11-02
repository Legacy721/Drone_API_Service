package com.legacy.Drones.exceptions;

public class SerialNumberRequiredException extends RuntimeException{
    public SerialNumberRequiredException(String message) {

        super(message);
    }
}
