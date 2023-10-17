package com.tcobep.solution.hms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "accessType_id", referencedColumnName = "id")

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "floor_id")
    private Floor floor;

}
