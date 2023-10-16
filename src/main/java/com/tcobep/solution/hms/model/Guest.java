package com.tcobep.solution.hms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private String email;

    @Column(nullable = false)
    private String nrc;

    private String phoneNumber;
    private String address;
    private String note;
}
