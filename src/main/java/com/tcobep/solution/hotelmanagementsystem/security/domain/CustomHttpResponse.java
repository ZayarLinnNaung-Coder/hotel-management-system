package com.tcobep.solution.hotelmanagementsystem.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomHttpResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}
