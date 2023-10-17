package com.tcobep.solution.hms.service.impl;

import com.tcobep.solution.hms.model.Authority;
import com.tcobep.solution.hms.repository.AuthorityRepository;
import com.tcobep.solution.hms.service.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Authority createAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority updateAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteAuthority(String authorityId) {
        authorityRepository.deleteById(authorityId);
    }

    @Override
    public Authority getAuthorityById(String authorityId) {
        return authorityRepository.findById(authorityId).orElse(null);
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }
}
