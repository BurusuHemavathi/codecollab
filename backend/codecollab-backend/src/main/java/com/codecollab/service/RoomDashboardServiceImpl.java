package com.codecollab.service;

import com.codecollab.dto.RoomDashboardResponse;
import com.codecollab.entity.RoomMember;
import com.codecollab.entity.RoomSheet;
import com.codecollab.repository.RoomMemberRepository;
import com.codecollab.repository.RoomSheetRepository;
import com.codecollab.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDashboardServiceImpl
        implements RoomDashboardService {

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Autowired
    private RoomSheetRepository roomSheetRepository;

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Override
    public RoomDashboardResponse getDashboard(
            String roomCode) {

        RoomDashboardResponse response =
                new RoomDashboardResponse();

        response.setRoomCode(roomCode);

        List<RoomMember> members =
                roomMemberRepository.findByRoomCode(roomCode);

        response.setTotalMembers(members.size());

        if (!members.isEmpty()) {
            response.setLeader(
                    members.get(0).getUserEmail());
        }

        RoomSheet roomSheet =
                roomSheetRepository
                        .findByRoomCode(roomCode)
                        .orElse(null);

        if (roomSheet != null) {
            response.setSheetId(
                    roomSheet.getSheetId());
        }

        int completed = 0;
        int bookmarked = 0;

        for (RoomMember member : members) {

            completed +=
                    userProgressRepository
                            .countByUserEmailAndCompletedTrue(
                                    member.getUserEmail());

            bookmarked +=
                    userProgressRepository
                            .countByUserEmailAndBookmarkedTrue(
                                    member.getUserEmail());
        }

        response.setTotalCompletedItems(completed);
        response.setTotalBookmarkedItems(bookmarked);

        return response;
    }
}