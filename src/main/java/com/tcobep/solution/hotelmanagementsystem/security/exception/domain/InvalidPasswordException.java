package com.tcobep.solution.hotelmanagementsystem.security.exception.domain;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message){
        super(message);
    }
}
