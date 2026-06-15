package com.codecollab.service;

import com.codecollab.dto.CreateRoomRequest;
import com.codecollab.entity.RoomMember;

import java.util.List;

public interface RoomService {

    String createRoom(CreateRoomRequest request);

    String joinRoom(String roomCode,
                    String userEmail);

    List<RoomMember> getRoomMembers(String roomCode);
}