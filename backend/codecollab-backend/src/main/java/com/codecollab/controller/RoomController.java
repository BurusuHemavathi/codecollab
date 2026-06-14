package com.codecollab.controller;

import com.codecollab.dto.CreateRoomRequest;
import com.codecollab.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public String createRoom(
            @RequestBody CreateRoomRequest request) {

        return roomService.createRoom(request);
    }
    @GetMapping("/test")
    public String test() {
        return "Room Controller Working";
    }
}