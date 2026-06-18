package com.codecollab.controller;

import com.codecollab.entity.ChatMessageEntity;
import com.codecollab.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatHistoryController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{roomCode}")
    public List<ChatMessageEntity> getMessages(
            @PathVariable String roomCode) {

        return chatService.getMessages(roomCode);
    }
}