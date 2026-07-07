package com.codecollab.service;

import com.codecollab.dto.RemoveMemberRequest;
import com.codecollab.entity.Room;
import com.codecollab.repository.RoomMemberRepository;
import com.codecollab.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomOwnerServiceImpl
        implements RoomOwnerService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Override
    @Transactional
    public String removeMember(
            RemoveMemberRequest request) {

        Room room = roomRepository
                .findByRoomCode(request.getRoomCode())
                .orElse(null);

        if (room == null) {
            return "Room Not Found";
        }

        if (!room.getCreatedBy()
                .equals(request.getOwnerEmail())) {

            return "Only Room Owner Can Remove Members";
        }

        roomMemberRepository
                .deleteByRoomCodeAndUserEmail(
                        request.getRoomCode(),
                        request.getMemberEmail());

        return "Member Removed Successfully";
    }
}