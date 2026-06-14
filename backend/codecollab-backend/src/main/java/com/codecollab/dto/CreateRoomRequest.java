package com.codecollab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomRequest {

    private String roomName;
    private String createdBy;
}