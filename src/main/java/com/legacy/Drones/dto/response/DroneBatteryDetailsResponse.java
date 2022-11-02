package com.legacy.Drones.dto.response;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneBatteryDetailsResponse {

    @NotNull
    private String status;
    @NotNull
    private String serialNumber;
    @NotNull
    private String batteryLevel;
    @NotNull
    private LocalDateTime timeStamp;
}
