package com.legacy.Drones.service;

import com.legacy.Drones.dto.request.DroneDeliveryRequest;
import com.legacy.Drones.dto.response.DeliveredDronesResponse;
import com.legacy.Drones.dto.response.DroneDeliveryResponse;

public interface DroneDeliveryService {


    DroneDeliveryResponse deliverLoad(DroneDeliveryRequest request);

    DeliveredDronesResponse getDeliveredDrones();
}
