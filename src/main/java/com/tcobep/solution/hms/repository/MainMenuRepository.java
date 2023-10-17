package com.tcobep.solution.hms.repository;

import com.tcobep.solution.hms.model.MainMenuValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMenuRepository extends JpaRepository<MainMenuValue, String> {
}
