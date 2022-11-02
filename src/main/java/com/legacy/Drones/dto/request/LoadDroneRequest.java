package com.legacy.Drones.dto.request;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoadDroneRequest {

    @NotNull
    @NotBlank
    private String source;

    @NotNull
    @NotBlank
    private String serialNumber;

    @NotNull
    @NotBlank
    private String destination;

    @NotNull
    @NotBlank
    private String code;
}
