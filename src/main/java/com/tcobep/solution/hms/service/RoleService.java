package com.tcobep.solution.hms.service;

import com.tcobep.solution.hms.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role updateRole(Role role);
    void deleteRole(String roleId);
    Role getRoleById(String roleId);
    List<Role> getAllRoles();
}
