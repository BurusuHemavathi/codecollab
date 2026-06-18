package com.codecollab.service;

import com.codecollab.entity.RoomCode;

public interface RoomCodeService {

    void saveCode(String roomCode,
                  String code);

    RoomCode getCode(String roomCode);
}