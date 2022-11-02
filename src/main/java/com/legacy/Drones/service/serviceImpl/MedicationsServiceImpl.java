package com.legacy.Drones.service.serviceImpl;

import com.legacy.Drones.models.Medications;
import com.legacy.Drones.repository.MedicationsRepository;
import com.legacy.Drones.service.MedicationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MedicationsServiceImpl implements MedicationsService {

    private final MedicationsRepository medicationsRepository;


    @Override
    public void preLoadMedicationData() {

        Medications medication1 = new Medications("LX3451","Panadol",100.0,"legacy67Y");
        Medications medication2 = new Medications("LX3452","Cepthrin",150.0,"legacy80Z");
        Medications medication3 = new Medications("LX3453","Lumefatrin",200.0,"legacy45C");
        Medications medication4 = new Medications("LX3454","Livolin",300.0,"legacy32G");
        Medications medication5 = new Medications("LX3455","Amoxicillin",400.0,"legacy87J");
        Medications medication6 = new Medications("LX3456","Augmentin",260.0,"legacy56A");
        Medications medication7 = new Medications("LX3457","Omeprazone",180.0,"legacy71T");
        Medications medication8 = new Medications("LX3458","Vitamin-c",400.0,"legacy12L");
        Medications medication9 = new Medications("LX3459","Aspirin",400.0,"legacy53S");
        Medications medication10 = new Medications("LX3460","Morphine",400.0,"legacy23H");
        medicationsRepository.save(medication1);
        medicationsRepository.save(medication2);
        medicationsRepository.save(medication3);
        medicationsRepository.save(medication4);
        medicationsRepository.save(medication5);
        medicationsRepository.save(medication6);
        medicationsRepository.save(medication7);
        medicationsRepository.save(medication8);
        medicationsRepository.save(medication9);
        medicationsRepository.save(medication10);

    }
}
