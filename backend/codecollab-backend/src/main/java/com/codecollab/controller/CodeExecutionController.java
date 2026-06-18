package com.codecollab.controller;

import com.codecollab.dto.CodeExecutionRequest;
import com.codecollab.service.CodeExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class CodeExecutionController {

    @Autowired
    private CodeExecutionService codeExecutionService;

    @PostMapping("/run")
    public String runCode(
            @RequestBody CodeExecutionRequest request) {

        return codeExecutionService
                .executeJavaCode(request.getCode());
    }
}