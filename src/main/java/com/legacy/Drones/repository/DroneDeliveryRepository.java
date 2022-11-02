package com.legacy.Drones.repository;

import com.legacy.Drones.models.DroneDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DroneDeliveryRepository extends JpaRepository<DroneDelivery, Integer> {
}
