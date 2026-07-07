package com.codecollab.service;

import com.codecollab.dto.RoomDashboardResponse;

public interface RoomDashboardService {

    RoomDashboardResponse getDashboard(
            String roomCode);

}