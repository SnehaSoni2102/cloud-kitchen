package com.cloudkitchen.backend.controller;

import com.cloudkitchen.backend.dto.LoginDto;
import com.cloudkitchen.backend.dto.RegisterDto;
import com.cloudkitchen.backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController{
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"login","signin"})
    public ResponseEntity<String> Login(@RequestBody LoginDto loginDto){
        String response =authService.Login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"signup","register"})
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
        System.out.println("register user=============================>"+" "+registerDto.toString());
        String respone =authService.register(registerDto);
        System.out.println("register user=============================>"+" "+respone);
        return new ResponseEntity<>(respone, HttpStatus.CREATED);
    }
}
