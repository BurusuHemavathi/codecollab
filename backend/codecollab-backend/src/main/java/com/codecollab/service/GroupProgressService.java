package com.codecollab.service;

import com.codecollab.dto.GroupProgressResponse;

public interface GroupProgressService {

    GroupProgressResponse getGroupProgress(String roomCode);

}