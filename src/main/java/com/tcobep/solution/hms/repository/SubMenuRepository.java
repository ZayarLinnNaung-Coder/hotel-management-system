package com.tcobep.solution.hms.repository;

import com.tcobep.solution.hms.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, String> {
}
