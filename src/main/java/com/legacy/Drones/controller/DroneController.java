package com.legacy.Drones.controller;


import com.legacy.Drones.dto.request.*;
import com.legacy.Drones.dto.response.*;
import com.legacy.Drones.service.serviceImpl.DroneDeliveryServiceImpl;
import com.legacy.Drones.service.serviceImpl.DroneServiceImpl;
import com.legacy.Drones.service.serviceImpl.LoadDroneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "api/v1/drone/")
@RequiredArgsConstructor
public class DroneController {

    private final DroneServiceImpl droneService;

    private final LoadDroneServiceImpl loadDroneService;

    private final DroneDeliveryServiceImpl deliveryService;



    @PostMapping(path = "register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneRegistrationResponse> registerDrone(
            @RequestBody @NotNull @Valid DroneRegistrationRequest request){
        return new ResponseEntity<>(droneService.registerDrone(request), HttpStatus.CREATED);
    }


    @GetMapping(path = "getAvailableDrones", produces = "application/json")
    public ResponseEntity<AvailableDronesResponse> getAvailableDrones (){
       return new ResponseEntity<>(droneService.getAvailableDrones(), HttpStatus.OK);
    }


    @PostMapping(path = "checkBatteryLevel", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneBatteryDetailsResponse> checkBatteryLevelDetails
            (@Valid @RequestBody DroneBatteryRequest request){
        return new ResponseEntity<>(droneService.checkBatteryLevel(request), HttpStatus.FOUND);

    }

    @PostMapping(path = "loadDrone", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoadDroneResponse> loadDrone(@RequestBody @Valid LoadDroneRequest request){
        return new ResponseEntity<>(loadDroneService.loadDrone(request), HttpStatus.CREATED);
    }



    @PostMapping(path = "getLoadedMedicationDetails",
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoadedMedicationResponse> getLoadedMedicationDetails
            (@Valid @RequestBody LoadedMedicationRequest request){
        return new ResponseEntity<>(loadDroneService.getLoadedMedicationOfADrone(request), HttpStatus.OK);
    }


    @PostMapping(path = "deliverLoad", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneDeliveryResponse> deliverLoad(@Valid @RequestBody DroneDeliveryRequest request){
        return new ResponseEntity<>(deliveryService.deliverLoad(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "getLoadedDrones", produces = "application/json")
    public ResponseEntity<LoadedDronesResponse> getLoadedDrones(){
        return new ResponseEntity<>(loadDroneService.getAllLoadedDrones(), HttpStatus.OK);
    }

    @GetMapping(path = "getDeliveredDrones", produces = "application/json")
    public ResponseEntity<DeliveredDronesResponse> getDeliveredDrones(){
        return new ResponseEntity<>(deliveryService.getDeliveredDrones(), HttpStatus.OK);
    }



}
