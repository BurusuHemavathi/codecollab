package com.codecollab.controller;

import com.codecollab.dto.CreateRoomRequest;
import com.codecollab.dto.JoinRoomRequest;
import com.codecollab.entity.RoomMember;
import com.codecollab.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/join")
    public String joinRoom(
            @RequestBody JoinRoomRequest request) {

        return roomService.joinRoom(
                request.getRoomCode(),
                request.getUserEmail());
    }

    @GetMapping("/members/{roomCode}")
    public List<RoomMember> getMembers(
            @PathVariable String roomCode) {

        return roomService.getRoomMembers(roomCode);
    }

}