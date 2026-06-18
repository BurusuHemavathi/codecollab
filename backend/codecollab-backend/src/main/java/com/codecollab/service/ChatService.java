package com.codecollab.service;

import com.codecollab.entity.ChatMessageEntity;

import java.util.List;

public interface ChatService {

    void saveMessage(ChatMessageEntity message);

    List<ChatMessageEntity> getMessages(String roomCode);
}