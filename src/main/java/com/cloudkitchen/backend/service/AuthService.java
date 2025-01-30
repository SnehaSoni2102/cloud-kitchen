package com.cloudkitchen.backend.service;

import com.cloudkitchen.backend.dto.LoginDto;
import com.cloudkitchen.backend.dto.RegisterDto;

public interface AuthService {
     String Login(LoginDto loginDto);
     String register(RegisterDto registerDto);
}
