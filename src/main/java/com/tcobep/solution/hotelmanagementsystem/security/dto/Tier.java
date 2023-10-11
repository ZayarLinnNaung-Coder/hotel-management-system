package com.tcobep.solution.hotelmanagementsystem.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tier {
    private Long id;
    private String name;
    private int rank;
    private double price;
    private String imgUrl;
    private Long professionId;
}
