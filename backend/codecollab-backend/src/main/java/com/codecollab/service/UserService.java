package com.codecollab.service;

import com.codecollab.dto.LoginRequest;
import com.codecollab.dto.RegisterRequest;
import com.codecollab.dto.LoginResponse;
public interface UserService {

    String registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);
}