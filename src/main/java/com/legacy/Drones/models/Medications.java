package com.legacy.Drones.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Medications {


    @Id
    @Column(name = "code", nullable = false, length = 10)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "image")
    private String image;

}
