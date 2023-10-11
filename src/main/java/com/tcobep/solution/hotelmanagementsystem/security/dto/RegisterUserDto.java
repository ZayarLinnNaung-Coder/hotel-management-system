package com.tcobep.solution.hotelmanagementsystem.security.dto;

import hackathon.dev.authservice.enumeration.Role;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String username;
    private String password;
    private String email;
    private Role role;
    private Long categoryId;
}
