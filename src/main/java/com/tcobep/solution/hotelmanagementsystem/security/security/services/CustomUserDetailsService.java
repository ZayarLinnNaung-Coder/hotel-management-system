package com.tcobep.solution.hotelmanagementsystem.security.security.services;

import hackathon.dev.authservice.client.ProfessionServiceClient;
import hackathon.dev.authservice.domain.ZResponse;
import hackathon.dev.authservice.dto.Professions;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfessionServiceClient professionServiceClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ZResponse<Professions> professionsZResponse = professionServiceClient.getUserByIdOrUsernameOrEmail(null, null, email);
        if(professionsZResponse == null || professionsZResponse.getData() == null){
            throw new UsernameNotFoundException("User is not found ... !");
        }

        return new SecurityUser(professionsZResponse.getData());
    }
}