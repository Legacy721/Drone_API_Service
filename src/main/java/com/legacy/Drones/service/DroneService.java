package com.legacy.Drones.service;

import com.legacy.Drones.dto.request.DroneBatteryRequest;
import com.legacy.Drones.dto.request.DroneRegistrationRequest;
import com.legacy.Drones.dto.response.AvailableDronesResponse;
import com.legacy.Drones.dto.response.DroneBatteryDetailsResponse;
import com.legacy.Drones.dto.response.DroneRegistrationResponse;

public interface DroneService {


    DroneRegistrationResponse registerDrone(DroneRegistrationRequest request);

    AvailableDronesResponse getAvailableDrones();

    DroneBatteryDetailsResponse checkBatteryLevel(DroneBatteryRequest request);

}
