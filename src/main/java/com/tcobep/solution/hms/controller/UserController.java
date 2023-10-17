package com.tcobep.solution.hms.controller;

import com.tcobep.solution.hms.configuration.UserPrincipal;
import com.tcobep.solution.hms.domain.HttpResponse;
import com.tcobep.solution.hms.exception.CustomExceptionHandler;
import com.tcobep.solution.hms.exception.custom.EmailExistException;
import com.tcobep.solution.hms.model.User;
import com.tcobep.solution.hms.provider.JWTTokenProvider;
import com.tcobep.solution.hms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tcobep.solution.hms.common.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static com.tcobep.solution.hms.domain.HttpResponse.createResponse;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController extends CustomExceptionHandler {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    public ResponseEntity<HttpResponse<User>> login(@RequestBody User user) {
        authenticate(user.getEmail(), user.getPassword());
        User loginUser = userService.findUserByEmail(user.getEmail());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return createResponse(loginUser, jwtHeader, OK);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpResponse<User>> register(@RequestBody User user) throws EmailExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return createResponse(newUser, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

}
