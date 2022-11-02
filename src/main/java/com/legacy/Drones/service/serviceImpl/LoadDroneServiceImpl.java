package com.legacy.Drones.service.serviceImpl;

import com.legacy.Drones.dto.request.LoadDroneRequest;
import com.legacy.Drones.dto.request.LoadedMedicationRequest;
import com.legacy.Drones.dto.response.LoadDroneResponse;
import com.legacy.Drones.dto.response.LoadedDronesResponse;
import com.legacy.Drones.dto.response.LoadedMedicationResponse;
import com.legacy.Drones.enums.State;
import com.legacy.Drones.exceptions.*;
import com.legacy.Drones.models.Drones;
import com.legacy.Drones.models.LoadDrone;
import com.legacy.Drones.models.Medications;
import com.legacy.Drones.repository.DroneRepository;
import com.legacy.Drones.repository.LoadDroneRepository;
import com.legacy.Drones.repository.MedicationsRepository;
import com.legacy.Drones.service.LoadDroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoadDroneServiceImpl implements LoadDroneService {


    private final DroneRepository droneRepository;

    private final MedicationsRepository medicationsRepository;

    private final LoadDroneRepository loadDroneRepository;

    private final MedicationsServiceImpl medicationsService;


    @Override
    public LoadDroneResponse loadDrone(LoadDroneRequest request) {

        medicationsService.preLoadMedicationData();

        Optional<Drones> drone = Optional.of(droneRepository.findDronesBySerialNumber(request.getSerialNumber())
                .orElseThrow(()-> new DroneNotFoundException("Drone not found exception")));
        drone.get().setState(State.LOADING);
        droneRepository.save(drone.get());
        Optional<Medications> medication = medicationsRepository.findMedicationsByCode(request.getCode());
        Optional<LoadDrone> checkLoadedDrone = loadDroneRepository.findByMedicationCode(request.getCode());

        if(checkLoadedDrone.isPresent())
            throw new MedicationAlreadyLoadedException("Medication with the code " +
                    request.getCode() + " has been loaded. Please try another one.");

        if(drone.isEmpty())
            throw new DroneNotFoundException("This drone with serial number "
                    + request.getSerialNumber() + " could not be found");

        if(medication.isEmpty())
            throw new MedicationNotFoundException("Medication does not exist");

        if(drone.get().getWeightLimit() < medication.get().getWeight())
            throw new WeightLimitExceededException("Medication's weight " +
                    "exceeds drone's weight limit");

        if(drone.get().getBatteryCapacity().compareTo(new BigDecimal(0.25)) < 0)
            throw new BatteryLowException("Drone cannot be Loaded, Battery is below 25%");


        LoadDrone loadDrone = LoadDrone.builder()
                .drone(drone.get())
                .medication(medication.get())
                .source(request.getSource())
                .createdon(LocalDateTime.now())
                .destination(request.getDestination())
                .destination(request.getDestination())
                .build();
        loadDroneRepository.save(loadDrone);

        drone.get().setState(State.LOADED);
        droneRepository.save(drone.get());

        LoadDroneResponse droneResponse = LoadDroneResponse.builder()
                .result("success")
                .serialNumber(request.getSerialNumber())
                .message("Drone Loaded Successfully")
                .timeStamp(LocalDateTime.now())
                .build();

        return droneResponse;
    }

    @Override
    public LoadedMedicationResponse getLoadedMedicationOfADrone(LoadedMedicationRequest request) {

            Optional<Drones> droneExists = droneRepository.findDronesBySerialNumber(request.getSerialNumber());

            if(request == null)
                throw new SerialNumberRequiredException("Serial Number is required");

            LoadDrone loadedDrone = loadDroneRepository.findByDrone(request.getSerialNumber());

            if(!droneExists.isPresent())
                throw new DroneNotFoundException("Drone might not have been registered");


            if(loadedDrone.getMedication() == null)
                throw new LoadedMedicationDetailsNotFoundException
                        ("Loaded medication details not available for this particular drone ");

            LoadedMedicationResponse response = LoadedMedicationResponse.builder()
                    .result("success")
                    .serialNumber(loadedDrone.getDrone().getSerialNumber())
                    .timeStamp(LocalDateTime.now())
                    .medication(loadedDrone.getMedication())
                    .build();

            return response;
    }

    @Override
    public LoadedDronesResponse getAllLoadedDrones() {
        List<Drones> drones = droneRepository.findAllByState(State.LOADED);
        return new LoadedDronesResponse("success",LocalDateTime.now(), drones);
    }


}
