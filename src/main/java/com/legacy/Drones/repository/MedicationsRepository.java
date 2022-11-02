package com.legacy.Drones.repository;

import com.legacy.Drones.models.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MedicationsRepository extends JpaRepository<Medications, String> {

    Optional<Medications> findMedicationsByCode(String code);
}
