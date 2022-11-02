package com.legacy.Drones.exceptions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MedicationAlreadyLoadedException extends RuntimeException {
    public MedicationAlreadyLoadedException(String message) {
        super(message);
    }
}
