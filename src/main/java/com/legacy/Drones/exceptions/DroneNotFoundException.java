package com.legacy.Drones.exceptions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroneNotFoundException extends RuntimeException {
    public DroneNotFoundException(String message) {
        super(message);
    }
}
