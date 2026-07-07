package com.codecollab.controller;

import com.codecollab.dto.GroupProgressResponse;
import com.codecollab.service.GroupProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group-progress")
public class GroupProgressController {

    @Autowired
    private GroupProgressService groupProgressService;

    @GetMapping("/{roomCode}")
    public GroupProgressResponse getGroupProgress(
            @PathVariable String roomCode) {

        return groupProgressService.getGroupProgress(roomCode);
    }
}