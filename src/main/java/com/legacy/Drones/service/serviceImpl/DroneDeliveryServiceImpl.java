package com.legacy.Drones.service.serviceImpl;


import com.legacy.Drones.dto.request.DroneDeliveryRequest;
import com.legacy.Drones.dto.response.DeliveredDronesResponse;
import com.legacy.Drones.dto.response.DroneDeliveryResponse;
import com.legacy.Drones.enums.State;
import com.legacy.Drones.exceptions.DroneNotFoundException;
import com.legacy.Drones.models.DroneDelivery;
import com.legacy.Drones.models.Drones;
import com.legacy.Drones.models.LoadDrone;
import com.legacy.Drones.repository.DroneDeliveryRepository;
import com.legacy.Drones.repository.DroneRepository;
import com.legacy.Drones.repository.LoadDroneRepository;
import com.legacy.Drones.service.DroneDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneDeliveryServiceImpl implements DroneDeliveryService {


    private final DroneRepository droneRepository;

    private final LoadDroneRepository loadDroneRepository;

    private final DroneDeliveryRepository deliveryRepository;



    @Override
    public DroneDeliveryResponse deliverLoad(DroneDeliveryRequest request) {

        Optional<Drones> drone = Optional.of(droneRepository.findDronesBySerialNumber(request.getSerialNumber())
                .orElseThrow(()-> new DroneNotFoundException("Drone not found exception")));
        drone.get().setState(State.DELIVERING);
        droneRepository.save(drone.get());

        LoadDrone loadDrone = loadDroneRepository.findByDrone(request.getSerialNumber());

        if(loadDrone == null)
            throw new DroneNotFoundException("Drone does not exists");

        DroneDelivery delivery = DroneDelivery.builder()
                .loadDrone(loadDrone)
                .deliveryTime(LocalDateTime.now())
                .build();
        deliveryRepository.save(delivery);
        drone.get().setState(State.DELIVERED);
        droneRepository.save(drone.get());

        DroneDeliveryResponse deliveryResponse = DroneDeliveryResponse.builder()
                .result("success")
                .serialNumber(request.getSerialNumber())
                .message("Drone delivered successfully")
                .timeStamp(LocalDateTime.now())
                .build();


        return deliveryResponse;
    }

    @Override
    public DeliveredDronesResponse getDeliveredDrones() {
        List<Drones> drones = droneRepository.findAllByState(State.DELIVERED);
        return new DeliveredDronesResponse("success", LocalDateTime.now(), drones);
    }
}
