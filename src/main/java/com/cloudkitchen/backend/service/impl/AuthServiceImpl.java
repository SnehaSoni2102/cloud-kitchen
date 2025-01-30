package com.cloudkitchen.backend.service.impl;

import com.cloudkitchen.backend.dto.LoginDto;
import com.cloudkitchen.backend.dto.RegisterDto;
import com.cloudkitchen.backend.model.Roles;
import com.cloudkitchen.backend.model.Users;
import com.cloudkitchen.backend.repository.RoleRepository;
import com.cloudkitchen.backend.repository.UsersRepository;
import com.cloudkitchen.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String Login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User Logged-in successfully!";
    }

    @Override
    public String register(RegisterDto registerDto) {

        //if user already present with username
        if(usersRepository.existsByUserName(registerDto.getUserName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Username already exist");
        }
        //if user already present with email
        if(usersRepository.existsByEmail(registerDto.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email already exist");
        }
        Users user= new Users();
        user.setName(registerDto.getName());
        user.setUserName(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Roles> role = new HashSet<>();
        Roles  userRole = roleRepository.findByRole("ROLE_USER").get();
        role.add(userRole);
        user.setRoles(role);
        usersRepository.save(user);

        return "User registerd successfully!.";
    }
}
