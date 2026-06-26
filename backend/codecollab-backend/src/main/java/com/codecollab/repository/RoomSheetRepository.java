package com.codecollab.repository;

import com.codecollab.entity.RoomSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomSheetRepository
        extends JpaRepository<RoomSheet, Long> {

    Optional<RoomSheet> findByRoomCode(
            String roomCode
    );
}