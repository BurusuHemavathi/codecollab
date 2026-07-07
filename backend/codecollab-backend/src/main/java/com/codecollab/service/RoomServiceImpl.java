package com.codecollab.service;

import com.codecollab.dto.CreateRoomRequest;
import com.codecollab.entity.Room;
import com.codecollab.entity.RoomMember;
import com.codecollab.repository.RoomMemberRepository;
import com.codecollab.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    @Override
    public String createRoom(CreateRoomRequest request) {

        Room room = new Room();

        room.setRoomName(request.getRoomName());
        room.setCreatedBy(request.getCreatedBy());

        String roomCode =
                UUID.randomUUID()
                        .toString()
                        .substring(0, 6)
                        .toUpperCase();

        room.setRoomCode(roomCode);

        roomRepository.save(room);

        return "Room Created Successfully. Code: " + roomCode;
    }

    @Override
    public String joinRoom(String roomCode,
                           String userEmail) {

        Room room =
                roomRepository
                        .findByRoomCode(roomCode)
                        .orElse(null);

        if (room == null) {
            return "Room Not Found";
        }

        RoomMember member = new RoomMember();

        member.setRoomCode(roomCode);
        member.setUserEmail(userEmail);

        roomMemberRepository.save(member);

        return "Joined Room: " + room.getRoomName();
    }

    @Override
    public List<RoomMember> getRoomMembers(String roomCode) {

        return roomMemberRepository.findByRoomCode(roomCode);
    }
}