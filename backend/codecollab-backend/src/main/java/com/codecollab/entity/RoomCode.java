package com.codecollab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room_code")
public class RoomCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomCode;

    @Column(columnDefinition = "LONGTEXT")
    private String code;

    public Long getId() {
        return id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}