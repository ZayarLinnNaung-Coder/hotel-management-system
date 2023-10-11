package com.tcobep.solution.hotelmanagementsystem.security.security.services;

import com.tcobep.solution.hotelmanagementsystem.security.dto.AuthProfessionDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.LoginResponseDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.LoginUserDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.RegisterUserDto;

public interface SecurityService {
    LoginResponseDto login(LoginUserDto loginDto);
    AuthProfessionDto register(RegisterUserDto registerUserDto);
}
