package com.legacy.Drones.service.serviceImpl;

import com.legacy.Drones.dto.request.DroneBatteryRequest;
import com.legacy.Drones.dto.request.DroneRegistrationRequest;
import com.legacy.Drones.dto.response.AvailableDronesResponse;
import com.legacy.Drones.dto.response.DroneBatteryDetailsResponse;
import com.legacy.Drones.dto.response.DroneRegistrationResponse;
import com.legacy.Drones.enums.State;
import com.legacy.Drones.exceptions.DroneAlreadyExistsException;
import com.legacy.Drones.exceptions.DroneBatteryLevelException;
import com.legacy.Drones.exceptions.DroneWeightLimitExceededException;
import com.legacy.Drones.exceptions.SerialNumberRequiredException;
import com.legacy.Drones.models.Drones;
import com.legacy.Drones.repository.DroneRepository;
import com.legacy.Drones.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;



    @Override
    public DroneRegistrationResponse registerDrone(DroneRegistrationRequest request) {

        boolean droneExists = droneRepository.findDronesBySerialNumber(request.getSerialNumber()).isPresent();

        if(droneExists){
            throw new DroneAlreadyExistsException("Sorry, Drone with this serial number " + request.getSerialNumber() +
                    "has been registered" );
        }

        if(request.getWeightLimit() > 500)
            throw new DroneWeightLimitExceededException("Drone weight limit cannot exceed 500gr");

        Drones drone = new Drones();
        drone.setState(State.IDLE);
        BeanUtils.copyProperties(request, drone);
        droneRepository.save(drone);

        DroneRegistrationResponse response = DroneRegistrationResponse.builder()
                .result("success")
                .serialNumber(request.getSerialNumber())
                .message("Drone registered successfully")
                .timeStamp(LocalDateTime.now())
                .build();


        return response;
    }

    @Override
    public AvailableDronesResponse getAvailableDrones() {
        List<Drones> drones = droneRepository.findAllByState(State.IDLE);
        return new AvailableDronesResponse("success", LocalDateTime.now(), drones );
    }

    @Override
    public DroneBatteryDetailsResponse checkBatteryLevel(DroneBatteryRequest request) {

        if(request.getSerialNumber().isEmpty())
            throw new SerialNumberRequiredException("Serial Number is Required");

        String pattern = "#%";
        DecimalFormat format = new DecimalFormat(pattern);
        Optional<Drones> droneBattery = droneRepository.findDronesBySerialNumber(request.getSerialNumber());

        if(!droneBattery.isPresent())
            throw new DroneBatteryLevelException("Drone Battery level Details not Found");

        DroneBatteryDetailsResponse batteryDetailsResponse = DroneBatteryDetailsResponse.builder()
                .status("success")
                .serialNumber(request.getSerialNumber())
                .batteryLevel(format.format(droneBattery.get().getBatteryCapacity()))
                .timeStamp(LocalDateTime.now())
                .build();

        return batteryDetailsResponse;
    }


}
