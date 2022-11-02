package com.legacy.Drones.dto.request;


import com.legacy.Drones.enums.State;
import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneRegistrationRequest {

    @Column(name = "serial_number",unique = true, nullable = false, length = 100)
    private String serialNumber;

    @Column(name = "drone_model", length = 20)
    private String model;

    @Column(name = "weight_limit")
    private Double weightLimit;

    @Column(name = "battery_capacity",precision = 3, scale = 2)
    private BigDecimal batteryCapacity;

    @Column(name = "drone_state")
    private State state = State.IDLE;

}
