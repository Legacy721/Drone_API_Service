package com.legacy.Drones.repository;


import com.legacy.Drones.enums.State;
import com.legacy.Drones.models.Drones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drones, String> {

    Optional<Drones> findDronesBySerialNumber(String serialNumber);

    List<Drones> findAllByState (State state);


    @Modifying
    @Query(value = "update Drones d set d.state = :state where  d.serialNumber= :serialno")
    void setUpdateState (@Param("state") State status, @Param("serialno") String serialno);
}
