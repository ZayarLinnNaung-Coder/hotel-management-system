package com.tcobep.solution.hms.exception;

import com.tcobep.solution.hms.common.constant.ExceptionConstant;
import com.tcobep.solution.hms.domain.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestControllerAdvice
public class CustomExHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> unknownException() {
        return createErrorResponse(CONFLICT, ExceptionConstant.UNKNOWN_EXCEPTION);
    }

    private ResponseEntity<CustomResponse> createErrorResponse(HttpStatus status, String exceptionText) {
        CustomResponse response = CustomResponse.builder().build();
        return new ResponseEntity<>(response, status);
    }

}
