package com.codecollab.service;

import com.codecollab.entity.RoomCode;
import com.codecollab.repository.RoomCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomCodeServiceImpl
        implements RoomCodeService {

    @Autowired
    private RoomCodeRepository roomCodeRepository;

    @Override
    public void saveCode(String roomCode,
                         String code) {

        RoomCode room =
                roomCodeRepository.findByRoomCode(roomCode);

        if (room == null) {

            room = new RoomCode();
            room.setRoomCode(roomCode);
        }

        room.setCode(code);

        roomCodeRepository.save(room);
    }

    @Override
    public RoomCode getCode(String roomCode) {

        return roomCodeRepository.findByRoomCode(roomCode);
    }
}