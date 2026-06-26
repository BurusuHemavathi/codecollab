package com.codecollab.service;

import com.codecollab.dto.AssignSheetRequest;
import com.codecollab.entity.RoomSheet;

public interface RoomSheetService {

    String assignSheetToRoom(
            AssignSheetRequest request);

    RoomSheet getRoomSheet(
            String roomCode);
}