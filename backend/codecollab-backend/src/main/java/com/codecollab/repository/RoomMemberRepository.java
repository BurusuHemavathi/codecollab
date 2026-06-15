package com.codecollab.repository;

import com.codecollab.entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomMemberRepository
        extends JpaRepository<RoomMember, Long> {

    List<RoomMember> findByRoomCode(String roomCode);
}