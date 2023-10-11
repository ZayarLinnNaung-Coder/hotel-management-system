package com.tcobep.solution.hotelmanagementsystem.security.exception.domain;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
