package com.legacy.Drones.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {


    private HttpStatus httpStatus;
    private String message;
    private String debugMessage;
    private LocalDateTime time = LocalDateTime.now();
}
