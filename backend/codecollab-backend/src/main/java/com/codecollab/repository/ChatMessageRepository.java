package com.codecollab.repository;

import com.codecollab.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository
        extends JpaRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> findByRoomCode(String roomCode);
}