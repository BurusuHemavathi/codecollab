package com.codecollab.service;

import com.codecollab.dto.LeaderboardMember;

import java.util.List;

public interface LeaderboardService {

    List<LeaderboardMember> getLeaderboard(String roomCode);

}