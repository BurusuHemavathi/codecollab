package com.codecollab.controller;

import com.codecollab.entity.RoomCode;
import com.codecollab.service.RoomCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class CodeController {

    @Autowired
    private RoomCodeService roomCodeService;

    @GetMapping("/{roomCode}")
    public RoomCode getCode(
            @PathVariable String roomCode) {

        return roomCodeService.getCode(roomCode);
    }
}