package com.tcobep.solution.hotelmanagementsystem.security.dto;

import hackathon.dev.authservice.domain.ZResponse;
import org.springframework.http.HttpStatus;

public class ResponseBuilder {

    public static ZResponse build(boolean success, HttpStatus httpStatus, String message, Object data){
        return ZResponse.builder()
                .success(success)
                .code(httpStatus.value())
                .data(data)
                .message(message)
                .build();
    }

}
