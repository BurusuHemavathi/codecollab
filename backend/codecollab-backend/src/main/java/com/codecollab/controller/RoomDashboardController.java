package com.codecollab.controller;

import com.codecollab.dto.RoomDashboardResponse;
import com.codecollab.service.RoomDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-dashboard")
public class RoomDashboardController {

    @Autowired
    private RoomDashboardService roomDashboardService;

    @GetMapping("/{roomCode}")
    public RoomDashboardResponse getDashboard(
            @PathVariable String roomCode) {

        return roomDashboardService
                .getDashboard(roomCode);
    }
}