package com.codecollab.service;

import com.codecollab.dto.AssignSheetRequest;
import com.codecollab.entity.RoomSheet;
import com.codecollab.repository.RoomSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomSheetServiceImpl
        implements RoomSheetService {

    @Autowired
    private RoomSheetRepository roomSheetRepository;

    @Override
    public String assignSheetToRoom(
            AssignSheetRequest request) {

        RoomSheet roomSheet =
                new RoomSheet();

        roomSheet.setRoomCode(
                request.getRoomCode());

        roomSheet.setSheetId(
                request.getSheetId());

        roomSheetRepository.save(roomSheet);

        return "Sheet Assigned Successfully";
    }

    @Override
    public RoomSheet getRoomSheet(
            String roomCode) {

        return roomSheetRepository
                .findByRoomCode(roomCode)
                .orElse(null);
    }
}