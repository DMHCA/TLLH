package com.romantrippel.tllh.controller;

import com.romantrippel.tllh.dto.LoginRequest;
import com.romantrippel.tllh.dto.LoginResponse;
import com.romantrippel.tllh.service.UserService;
import com.romantrippel.tllh.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {

        boolean isAuthenticated = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (!isAuthenticated) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }

        String token = generateJwtToken(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse(token);

        return ResponseEntity.ok(loginResponse);
    }


        //TODO implement JWT generation
    private String generateJwtToken (String login) {
        if (StringUtil.isEmptyOrBlank(login)) {
            return "invalidUser";
        }

        return  "validUser";
    }
}
