package com.tcobep.solution.hms.repository;

import com.tcobep.solution.hms.model.MainMenuValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMenuValueRepository extends JpaRepository<MainMenuValue, String> {
}
