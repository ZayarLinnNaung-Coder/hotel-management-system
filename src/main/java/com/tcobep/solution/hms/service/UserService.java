package com.tcobep.solution.hms.service;

import com.tcobep.solution.hms.exception.custom.EmailExistException;
import com.tcobep.solution.hms.model.User;

public interface UserService {
    User register(String firstName, String lastName, String email, String password) throws EmailExistException;

    User findUserByEmail(String email);

}
