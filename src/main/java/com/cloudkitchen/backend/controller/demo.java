package com.cloudkitchen.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo/")
public class demo {

    @GetMapping("sneha")
    public String getREQ(){
        return "Hello world";
    }
}
