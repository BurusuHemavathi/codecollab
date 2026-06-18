package com.codecollab.service;

import org.springframework.stereotype.Service;

@Service
public class CodeExecutionServiceImpl
        implements CodeExecutionService {

    @Override
    public String executeJavaCode(String code) {

        return "Execution Module Coming Next";
    }
}