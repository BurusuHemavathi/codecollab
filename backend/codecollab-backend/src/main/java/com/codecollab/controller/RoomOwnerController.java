package com.codecollab.controller;

import com.codecollab.dto.RemoveMemberRequest;
import com.codecollab.service.RoomOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-owner")
public class RoomOwnerController {

    @Autowired
    private RoomOwnerService roomOwnerService;



    @PostMapping("/remove-member")
    public String removeMember(
            @RequestBody RemoveMemberRequest request) {

        System.out.println("REMOVE MEMBER API HIT");

        return roomOwnerService.removeMember(request);
    }
}