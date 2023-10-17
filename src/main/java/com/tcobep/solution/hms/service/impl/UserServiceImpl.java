package com.tcobep.solution.hms.service.impl;

import com.tcobep.solution.hms.common.constant.UserImplConstant;
import com.tcobep.solution.hms.configuration.UserPrincipal;
import com.tcobep.solution.hms.exception.custom.EmailExistException;
import com.tcobep.solution.hms.model.Role;
import com.tcobep.solution.hms.model.User;
import com.tcobep.solution.hms.repository.RoleRepository;
import com.tcobep.solution.hms.repository.UserRepository;
import com.tcobep.solution.hms.service.LoginAttemptService;
import com.tcobep.solution.hms.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists.";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final LoginAttemptService loginAttemptService;

    @Override
    public User register(String firstName, String lastName, String email, String password) throws EmailExistException {
        validateNewEmail(email);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(firstName + " " + lastName);
        user.setEmail(email);
        user.setJoinDate(new Date());
        user.setPassword(encodePassword(password));
        user.setActive(true);
        user.setNotLocked(true);

        Role guestRole = roleRepository.findRoleByName("ROLE_GUEST");
        if (guestRole != null) {
            user.getRoles().add(guestRole);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(UserImplConstant.NO_USER_FOUND_BY_EMAIL + email);
        } else {
            validateLoginAttempt(user);
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            return userPrincipal;
        }
    }

    private User validateNewEmail(String newEmail) throws EmailExistException {
        User userByNewEmail = findUserByEmail(newEmail);

        if (userByNewEmail != null) {
            throw new EmailExistException(EMAIL_ALREADY_EXISTS);
        }
        return null;
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private void validateLoginAttempt(User user) {
        if (user.isNotLocked()) {
            user.setNotLocked(!loginAttemptService.hasExceededMaxAttempts(user.getEmail()));
        } else {
            loginAttemptService.evictUserFromLoginAttemptCache(user.getEmail());
        }
    }
}
