package com.legacy.Drones.models;

import com.legacy.Drones.enums.State;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Drones {


    @Id
    @Column(name = "serial_number",unique = true, nullable = false, length = 100)
    private String serialNumber;

    @Column(name = "drone_model", length = 20)
    private String model;

    @Column(name = "weight_limit")
    private Double weightLimit;

    @Column(name = "battery_capacity",precision = 3, scale = 2)
    private BigDecimal batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "drone_state")
    private State state;


}
