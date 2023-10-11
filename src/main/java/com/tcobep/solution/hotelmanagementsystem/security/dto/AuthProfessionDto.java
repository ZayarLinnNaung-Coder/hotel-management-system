package com.tcobep.solution.hotelmanagementsystem.security.dto;

import hackathon.dev.authservice.constant.ActiveStatus;
import hackathon.dev.authservice.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthProfessionDto {
    private Long id;

    private String username;
    private String password;
    private String email;

    private String phoneNumber;
    private String address;
    private String profileImg;
    private String coverPhoto;
    private String bio;
    private String profileLink;
    private Role role;

    private ActiveStatus activeStatus;
    private List<Tier> tierList;
    private Category category;
}
