package com.cloudkitchen.backend.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenrater {
    public static void main(String[] args){
        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        //System.out.println(passwordEncoder.encode("sneha"));
        System.out.println(passwordEncoder.encode("neha"));
    }
}
