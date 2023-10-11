package com.tcobep.solution.hotelmanagementsystem.security.controller;

import com.tcobep.solution.hotelmanagementsystem.security.domain.ZResponse;
import com.tcobep.solution.hotelmanagementsystem.security.dto.AuthProfessionDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.LoginResponseDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.LoginUserDto;
import com.tcobep.solution.hotelmanagementsystem.security.dto.RegisterUserDto;
import com.tcobep.solution.hotelmanagementsystem.security.security.services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@AllArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

//    @GetMapping("/me")
//    public ResponseEntity<ZResponse> getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Optional<User> me = userService.findUserByUsername((String) authentication.getPrincipal());
//
//        if(me.isPresent()){
//            return ResponseEntity.ok(
//                    ResponseBuilder.build(true, HttpStatus.OK, "Successfully fetched", me));
//        }
//
//        return new ResponseEntity<>(
//                ResponseBuilder.build(true, HttpStatus.NO_CONTENT, "Who are you", me), HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginDto){
        LoginResponseDto response = securityService.login(loginDto);
        if (!Objects.isNull(response) && StringUtils.hasText(response.getToken())){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/register")
    public ResponseEntity<ZResponse<AuthProfessionDto>> addNewUser(@RequestBody RegisterUserDto user){

        final AuthProfessionDto professions = securityService.register(user);

        return ResponseEntity.ok( ZResponse.<AuthProfessionDto>builder()
                .success(true)
                .message("Successfully registered...")
                .data(professions)
                .build());
    }

}
