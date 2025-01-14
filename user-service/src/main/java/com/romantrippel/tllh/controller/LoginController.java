package com.romantrippel.tllh.controller;

import com.romantrippel.tllh.dto.LoginRequest;
import com.romantrippel.tllh.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) {

        //TODO implement authenticate method
//        boolean isAuthenticated = authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        boolean isAuthenticated = true;

        if (!isAuthenticated) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }

        String token = generateJwtToken(loginRequest.getUsername());

        LoginResponse loginResponse = new LoginResponse(token);

        return ResponseEntity.ok(loginResponse);
    }


        //TODO implement JWT generation
    private String generateJwtToken (String login) {

        //some code
        return login;
    }
}
