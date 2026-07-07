package com.codecollab.service;

import com.codecollab.dto.GroupMemberProgress;
import com.codecollab.dto.GroupProgressResponse;
import com.codecollab.entity.RoomMember;
import com.codecollab.repository.RoomMemberRepository;
import com.codecollab.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupProgressServiceImpl
        implements GroupProgressService {

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Override
    public GroupProgressResponse getGroupProgress(
            String roomCode) {

        List<RoomMember> members =
                roomMemberRepository.findByRoomCode(roomCode);

        List<GroupMemberProgress> memberProgressList =
                new ArrayList<>();

        int totalCompleted = 0;

        for (RoomMember member : members) {

            GroupMemberProgress progress =
                    new GroupMemberProgress();

            progress.setUserEmail(member.getUserEmail());

            int completed =
                    (int) userProgressRepository
                            .countByUserEmailAndCompletedTrue(
                                    member.getUserEmail());

            int bookmarked =
                    (int) userProgressRepository
                            .countByUserEmailAndBookmarkedTrue(
                                    member.getUserEmail());

            progress.setCompletedItems(completed);
            progress.setBookmarkedItems(bookmarked);

            totalCompleted += completed;

            memberProgressList.add(progress);
        }

        GroupProgressResponse response =
                new GroupProgressResponse();

        response.setRoomCode(roomCode);
        response.setTotalMembers(members.size());
        response.setTotalCompletedItems(totalCompleted);
        response.setMembers(memberProgressList);

        return response;
    }
}