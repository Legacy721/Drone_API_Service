package com.legacy.Drones.service;

import com.legacy.Drones.dto.request.LoadDroneRequest;
import com.legacy.Drones.dto.request.LoadedMedicationRequest;
import com.legacy.Drones.dto.response.LoadDroneResponse;
import com.legacy.Drones.dto.response.LoadedDronesResponse;
import com.legacy.Drones.dto.response.LoadedMedicationResponse;

public interface LoadDroneService {


    LoadDroneResponse loadDrone(LoadDroneRequest request);

    LoadedMedicationResponse getLoadedMedicationOfADrone(LoadedMedicationRequest request);

    LoadedDronesResponse getAllLoadedDrones();
}
