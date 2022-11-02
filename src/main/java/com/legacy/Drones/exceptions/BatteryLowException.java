package com.legacy.Drones.exceptions;

public class BatteryLowException extends RuntimeException {
    public BatteryLowException(String message) {
        super(message);
    }
}
