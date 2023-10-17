package com.tcobep.solution.hms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SUB_MENU_VALUE")
public class SubMenuValue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "MAIN_MENU_VALUE_ID")
    private MainMenuValue mainMenuValue;

    @ManyToOne
    @JoinColumn(name = "SUB_MENU_ID")
    private SubMenu subMenu;


}

