package com.codecollab.repository;

import com.codecollab.entity.RoomCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCodeRepository
        extends JpaRepository<RoomCode, Long> {

    RoomCode findByRoomCode(String roomCode);
}