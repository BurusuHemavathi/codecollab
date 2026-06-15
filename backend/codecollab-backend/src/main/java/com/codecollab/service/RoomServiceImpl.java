package com.codecollab.service;

import com.codecollab.dto.CreateRoomRequest;
import com.codecollab.entity.Room;
import com.codecollab.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

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
    public String joinRoom(String roomCode) {

        Room room =
                roomRepository.findByRoomCode(roomCode);

        if (room == null) {
            return "Room Not Found";
        }

        return "Joined Room: "
                + room.getRoomName();
    }
}