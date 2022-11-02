package com.legacy.Drones.repository;

import com.legacy.Drones.dto.request.LoadedMedicationRequest;
import com.legacy.Drones.models.LoadDrone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoadDroneRepository extends JpaRepository<LoadDrone, Integer> {

    Optional<LoadDrone> findByMedicationCode(String code);

    @Query(value = "SELECT * from load_drone_tbl e where e.fk_serial_number =:serialNumber ", nativeQuery = true)
    LoadDrone findByDrone(@Param("serialNumber") String serialNumber);

}
