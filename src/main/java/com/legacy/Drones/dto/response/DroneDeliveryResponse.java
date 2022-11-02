package com.legacy.Drones.dto.response;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneDeliveryResponse {

    private String result;
    private String serialNumber;
    private String message;
    private LocalDateTime timeStamp;
}
