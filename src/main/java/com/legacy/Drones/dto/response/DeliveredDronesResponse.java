package com.legacy.Drones.dto.response;

import com.legacy.Drones.models.Drones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class DeliveredDronesResponse {


    private String result;

    @NotNull
    private LocalDateTime timeStamp;

    @NotNull
    private List<Drones> availableDrones;
}
