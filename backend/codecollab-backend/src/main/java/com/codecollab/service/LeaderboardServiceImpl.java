package com.codecollab.service;

import com.codecollab.dto.LeaderboardMember;
import com.codecollab.entity.RoomMember;
import com.codecollab.repository.RoomMemberRepository;
import com.codecollab.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeaderboardServiceImpl
        implements LeaderboardService {

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Override
    public List<LeaderboardMember> getLeaderboard(
            String roomCode) {

        List<RoomMember> members =
                roomMemberRepository.findByRoomCode(roomCode);

        List<LeaderboardMember> leaderboard =
                new ArrayList<>();

        for (RoomMember member : members) {

            LeaderboardMember dto =
                    new LeaderboardMember();

            dto.setUserEmail(member.getUserEmail());

            dto.setCompletedItems(
                    (int) userProgressRepository
                            .countByUserEmailAndCompletedTrue(
                                    member.getUserEmail()));

            leaderboard.add(dto);
        }

        leaderboard.sort(
                Comparator.comparingInt(
                                LeaderboardMember::getCompletedItems)
                        .reversed());

        return leaderboard;
    }
}