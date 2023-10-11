package com.tcobep.solution.hotelmanagementsystem.security.exception.domain;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
