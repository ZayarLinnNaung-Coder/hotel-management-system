package com.tcobep.solution.hotelmanagementsystem.security.dto;

import hackathon.dev.authservice.constant.ActiveStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUser {

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

    private ActiveStatus activeStatus;
}
