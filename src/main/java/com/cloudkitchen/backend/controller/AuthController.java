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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class AuthController{
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = {"login","signin"})
    public ResponseEntity<String> Login(@RequestBody LoginDto loginDto){
        System.out.println("login======>"+" "+loginDto.toString());
        String response =authService.Login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"signup","register"})
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
//        List<Integer> l1=new ArrayList<>();
//        List<Integer> l2=new ArrayList<>();
//        for(int i=0;i<=10;i++)l1.add(i);
//        for(int i=5;i<=10;i++)l2.add(i);
//        l1.retainAll(l2);
        System.out.println("register user=============================>"+" "+registerDto.toString());
        String respone =authService.register(registerDto);
        System.out.println("register user=============================>"+" "+respone);
        return new ResponseEntity<>(respone, HttpStatus.CREATED);
    }
}
