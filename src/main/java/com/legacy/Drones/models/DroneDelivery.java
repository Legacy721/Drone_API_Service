package com.legacy.Drones.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "drone_delivery")
public class DroneDelivery {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "delivery_time", nullable = false)
    private LocalDateTime deliveryTime;

    @OneToOne(targetEntity = LoadDrone.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_trackingId", referencedColumnName = "trackingId")
    private LoadDrone loadDrone;
}
