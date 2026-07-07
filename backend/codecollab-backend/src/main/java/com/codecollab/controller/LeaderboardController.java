package com.codecollab.controller;

import com.codecollab.dto.LeaderboardMember;
import com.codecollab.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping("/{roomCode}")
    public List<LeaderboardMember> getLeaderboard(
            @PathVariable String roomCode) {

        return leaderboardService
                .getLeaderboard(roomCode);
    }
}