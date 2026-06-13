package com.codecollab.controller;

import com.codecollab.dto.RegisterRequest;
import com.codecollab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codecollab.dto.LoginRequest;
import com.codecollab.dto.LoginResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }
    @PostMapping("/login")
    public LoginResponse loginUser(
            @RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
    @GetMapping("/profile")
    public String profile() {
        return "Welcome to CodeCollab";
    }
}
