package com.tcobep.solution.hotelmanagementsystem.security.exception;

import hackathon.dev.authservice.domain.CustomHttpResponse;
import hackathon.dev.authservice.domain.ZResponse;
import hackathon.dev.authservice.dto.ResponseBuilder;
import hackathon.dev.authservice.exception.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static hackathon.dev.authservice.constant.UserConstant.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<ZResponse> usernameAlreadyExistException() {
        return createHttpResponse(CONFLICT, USERNAME_ALREADY_EXIST);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ZResponse> emailAlreadyExistException() {
        return createHttpResponse(CONFLICT, EMAIL_ALREADY_EXIST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ZResponse> userNotFoundException() {
        return createHttpResponse(BAD_REQUEST, USER_NOT_FOUND_BY_USERNAME);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ZResponse> usernameNotFoundException() {
        return createHttpResponse(BAD_REQUEST, USER_NOT_FOUND_BY_USERNAME);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ZResponse> invalidPasswordException() {
        return createHttpResponse(BAD_REQUEST, INVALID_PASSWORD);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ZResponse> noHandlerFoundException() {
        return createHttpResponse(BAD_REQUEST, "No such path found");
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ZResponse> dataNotFoundException(Exception e) {
        return createHttpResponse(BAD_REQUEST, e.getMessage());
    }

    private ResponseEntity<ZResponse> createHttpResponse(HttpStatus httpStatus, String message){
        ZResponse response = ResponseBuilder.build(false, httpStatus, message, null);
        return new ResponseEntity<>(response, httpStatus);
    }
}
