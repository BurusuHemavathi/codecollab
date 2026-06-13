package com.codecollab.service;

import com.codecollab.dto.LoginRequest;
import com.codecollab.dto.RegisterRequest;

public interface UserService {

    String registerUser(RegisterRequest request);

    String loginUser(LoginRequest request);
}