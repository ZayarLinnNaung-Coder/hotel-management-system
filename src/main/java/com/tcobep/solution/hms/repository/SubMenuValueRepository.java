package com.tcobep.solution.hms.repository;

import com.tcobep.solution.hms.model.SubMenuValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuValueRepository extends JpaRepository<SubMenuValue, String> {
}
