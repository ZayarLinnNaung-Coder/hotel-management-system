package com.tcobep.solution.hotelmanagementsystem.exception;

import com.tcobep.solution.hotelmanagementsystem.domain.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.tcobep.solution.hotelmanagementsystem.constant.ExceptionConstant.*;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestControllerAdvice
public class CustomExHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> unknownException() {
        return createErrorResponse(CONFLICT, UNKNOWN_EXCEPTION);
    }

    private ResponseEntity<CustomResponse> createErrorResponse(HttpStatus status, String exceptionText) {
        CustomResponse response = CustomResponse.builder().build();
        return new ResponseEntity<>(response, status);
    }

}
