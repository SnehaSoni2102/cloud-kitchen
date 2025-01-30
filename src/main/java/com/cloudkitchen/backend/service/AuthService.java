package com.cloudkitchen.backend.service;

import com.cloudkitchen.backend.dto.LoginDto;

public interface AuthService {
     String Login(LoginDto loginDto);
}
