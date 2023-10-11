package com.tcobep.solution.hotelmanagementsystem.security.exception.domain;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String message){
        super(message);
    }
}
