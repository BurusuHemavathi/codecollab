package com.codecollab.controller;

import com.codecollab.dto.ChatMessage;
import com.codecollab.entity.ChatMessageEntity;
import com.codecollab.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    public void sendMessage(ChatMessage message) {

        ChatMessageEntity entity =
                new ChatMessageEntity();

        entity.setSender(message.getSender());
        entity.setRoomCode(message.getRoomCode());
        entity.setMessage(message.getMessage());

        chatService.saveMessage(entity);

        messagingTemplate.convertAndSend(
                "/topic/room/" + message.getRoomCode(),
                message
        );
    }
}