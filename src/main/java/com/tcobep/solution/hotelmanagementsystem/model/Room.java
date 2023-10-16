package com.tcobep.solution.hotelmanagementsystem.model;

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
public class Room {
    @Id
    private UUID id;
    private String name;
    private String description;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "accessType_id", referencedColumnName = "id")

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "floor_id")
    private Floor floor;

}
