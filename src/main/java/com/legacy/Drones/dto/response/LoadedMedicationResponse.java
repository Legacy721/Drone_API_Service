package com.legacy.Drones.dto.response;

import com.legacy.Drones.models.Medications;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoadedMedicationResponse {

    private String result;
    private String serialNumber;
    private Medications medication;
    private LocalDateTime timeStamp;

}
