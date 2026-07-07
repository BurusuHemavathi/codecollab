package com.codecollab.service;

import com.codecollab.dto.RemoveMemberRequest;

public interface RoomOwnerService {

    String removeMember(
            RemoveMemberRequest request);

}