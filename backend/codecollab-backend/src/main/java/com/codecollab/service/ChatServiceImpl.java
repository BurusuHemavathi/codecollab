package com.codecollab.service;

import com.codecollab.entity.ChatMessageEntity;
import com.codecollab.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public void saveMessage(ChatMessageEntity message) {

        chatMessageRepository.save(message);
    }

    @Override
    public List<ChatMessageEntity> getMessages(String roomCode) {

        return chatMessageRepository.findByRoomCode(roomCode);
    }
}
