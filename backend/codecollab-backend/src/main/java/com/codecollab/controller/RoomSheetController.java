package com.codecollab.controller;

import com.codecollab.dto.AssignSheetRequest;
import com.codecollab.entity.RoomSheet;
import com.codecollab.service.RoomSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-sheets")
public class RoomSheetController {

    @Autowired
    private RoomSheetService roomSheetService;

    @PostMapping("/assign")
    public String assignSheet(
            @RequestBody AssignSheetRequest request) {

        return roomSheetService
                .assignSheetToRoom(request);
    }

    @GetMapping("/{roomCode}")
    public RoomSheet getRoomSheet(
            @PathVariable String roomCode) {

        return roomSheetService
                .getRoomSheet(roomCode);
    }
}