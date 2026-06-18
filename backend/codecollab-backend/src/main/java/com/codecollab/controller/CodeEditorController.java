package com.codecollab.controller;

import com.codecollab.dto.CodeUpdate;
import com.codecollab.service.RoomCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CodeEditorController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RoomCodeService roomCodeService;

    @MessageMapping("/codeUpdate")
    public void updateCode(CodeUpdate update) {

        roomCodeService.saveCode(
                update.getRoomCode(),
                update.getCode()
        );

        messagingTemplate.convertAndSend(
                "/topic/code/" + update.getRoomCode(),
                update
        );
    }
}