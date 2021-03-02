package com.udemy.cookbook.controllers;

import com.udemy.cookbook.security.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {
    @GetMapping("/auth")
    public AuthenticationBean auth() {
        return new AuthenticationBean("You are now authenticated!");
    }
}
