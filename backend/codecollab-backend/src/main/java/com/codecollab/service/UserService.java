package com.codecollab.service;

import com.codecollab.dto.RegisterRequest;

public interface UserService {
    String registerUser(RegisterRequest request);
}