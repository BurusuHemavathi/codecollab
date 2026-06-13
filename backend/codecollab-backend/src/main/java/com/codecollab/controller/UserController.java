package com.codecollab.controller;

import com.codecollab.dto.RegisterRequest;
import com.codecollab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codecollab.dto.LoginRequest;

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
    public String loginUser(
            @RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}
