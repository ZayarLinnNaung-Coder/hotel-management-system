package com.tcobep.solution.hms.service;

import com.tcobep.solution.hms.model.Authority;

import java.util.List;

public interface AuthorityService {
    Authority createAuthority(Authority authority);
    Authority updateAuthority(Authority authority);
    void deleteAuthority(String authorityId);
    Authority getAuthorityById(String authorityId);
    List<Authority> getAllAuthorities();
}
