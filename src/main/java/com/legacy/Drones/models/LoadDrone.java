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
@Table(name = "load_drone_tbl")
public class LoadDrone {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trackingId;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "createdon", nullable = false)
    private LocalDateTime createdon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_serial_number", referencedColumnName = "serial_number")
    private Drones drone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_code", referencedColumnName = "code")
    private Medications medication;

}
