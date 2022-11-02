package com.legacy.Drones.exceptions;

public class DroneAlreadyExistsException extends RuntimeException {
    public DroneAlreadyExistsException(String message) {
        super(message);
    }
}
