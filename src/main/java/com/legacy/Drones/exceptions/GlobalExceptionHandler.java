package com.legacy.Drones.exceptions;

import com.legacy.Drones.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;


@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(DroneAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponse> handleDroneAlreadyExist(final DroneAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.ALREADY_REPORTED);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Drone Has Been Registered");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(DroneBatteryLevelException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleBatteryLevelDetailsNotFound(final DroneBatteryLevelException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Drone not Found");

        return ResponseEntity.of(Optional.of(errorResponse));
    }

    @ExceptionHandler(SerialNumberRequiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleSerialNumberRequired(final SerialNumberRequiredException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Serial number is required. Please provide a valid serial number");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(MedicationAlreadyLoadedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleMedicationAlreadyLoaded(final MedicationAlreadyLoadedException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("The Medication has already been loaded. Please Load another one");

        return ResponseEntity.of(Optional.of(errorResponse));
    }

    @ExceptionHandler(DroneNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleDroneNotFound(final DroneNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Drone not found, might not have been registered");

        return ResponseEntity.of(Optional.of(errorResponse));
    }



    @ExceptionHandler(WeightLimitExceededException.class)
    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public ResponseEntity<ErrorResponse> handleWeightLimitExceeded(final WeightLimitExceededException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Medication's weight exceeds drones weight limit");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(BatteryLowException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public ResponseEntity<ErrorResponse> handleBatteryLevelLow(final BatteryLowException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.ALREADY_REPORTED);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Battery is below 25%");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(MedicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleMedicationNotFound(final MedicationNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.ALREADY_REPORTED);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Battery is below 25%");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(LoadedMedicationDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleLoadedMedicationDetailsNotFound
            (final LoadedMedicationDetailsNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Loaded Medication details not found");

        return ResponseEntity.of(Optional.of(errorResponse));
    }


    @ExceptionHandler(DroneWeightLimitExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleDroneWeightLimitExceeded
            (final DroneWeightLimitExceededException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Drone's weight limit cannot be more than 500gr");

        return ResponseEntity.of(Optional.of(errorResponse));
    }

}
