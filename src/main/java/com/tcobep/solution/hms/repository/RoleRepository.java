package com.tcobep.solution.hms.repository;

import com.tcobep.solution.hms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findRoleByName(String name);

}