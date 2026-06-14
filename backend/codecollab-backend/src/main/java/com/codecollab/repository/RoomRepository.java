package com.codecollab.repository;

import com.codecollab.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository
        extends JpaRepository<Room, Long> {

    Room findByRoomCode(String roomCode);
}