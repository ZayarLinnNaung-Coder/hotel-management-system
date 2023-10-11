package com.tcobep.solution.hotelmanagementsystem.security.security.services.impl;

import com.tcobep.solution.hotelmanagementsystem.security.constant.ActiveStatus;
import com.tcobep.solution.hotelmanagementsystem.security.constant.CustomMessage;
import com.tcobep.solution.hotelmanagementsystem.security.domain.ZResponse;
import com.tcobep.solution.hotelmanagementsystem.security.dto.*;
import com.tcobep.solution.hotelmanagementsystem.security.exception.domain.EmailAlreadyExistException;
import com.tcobep.solution.hotelmanagementsystem.security.exception.domain.UserNotFoundException;
import com.tcobep.solution.hotelmanagementsystem.security.security.services.SecurityService;
import com.tcobep.solution.hotelmanagementsystem.security.security.utils.JwtUtilities;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtilities jwtUtilities;
    private final ModelMapper mapper;

//    private final RabbitTemplate template;

    @Override
    @Transactional
    public LoginResponseDto login(LoginUserDto loginDto) {
        LoginResponseDto response = new LoginResponseDto();

        ZResponse<AuthProfessionDto> professionsZResponse = new ZResponse<>();

        if(professionsZResponse.getData() != null){
            AuthProfessionDto loginUser = professionsZResponse.getData();
            boolean isMatchPwd = passwordEncoder.matches(loginDto.getPassword(), loginUser.getPassword());
            if(isMatchPwd){
                response.setToken(generateAccessToken(loginUser.getUsername()));
                response.setType("Bearer");
                response.setUser(loginUser);
                return response;
            }
        }else{
            throw new UserNotFoundException("User is not found");
        }
        return null;
    }

    @Override
    @Transactional
    public AuthProfessionDto register(RegisterUserDto registerUserDto) {

        ZResponse<AuthProfessionDto> user = null;

        try{

            ZResponse<AuthProfessionDto> professionsZResponse = null;

            if(professionsZResponse != null){
                throw new EmailAlreadyExistException("This email is already registered. Are you trying to login?");
            }

            String encodedPassword = passwordEncoder.encode(registerUserDto.getPassword());
            registerUserDto.setPassword(encodedPassword);

            Professions professions = mapper.map(registerUserDto, Professions.class);
            professions.setActiveStatus(ActiveStatus.ACTIVE);

//            user = professionServiceClient.saveProfessions(professions);

        } catch (EmailAlreadyExistException e) {
            throw  e;
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthProfessionDto professions = user.getData();

        // Send to message queue
        CustomMessage message = new CustomMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setEmail(professions.getEmail());
        message.setUsername(professions.getUsername());
        message.setAccountCreatedDate(new Date());

//        template.convertAndSend(QueueConfig.EXCHANGE,
//                QueueConfig.ROUTING_KEY, message);

        return professions;
    }

    private String generateAccessToken(Professions loginUser) {
        return generateAccessToken(loginUser.getUsername());
    }

    private String generateAccessToken(String username) {
        return jwtUtilities.generateToken(username, null);
    }
}
