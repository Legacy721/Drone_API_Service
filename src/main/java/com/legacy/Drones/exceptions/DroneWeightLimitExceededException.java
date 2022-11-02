package com.legacy.Drones.exceptions;

public class DroneWeightLimitExceededException extends RuntimeException {
    public DroneWeightLimitExceededException(String message) {
        super(message);
    }
}
