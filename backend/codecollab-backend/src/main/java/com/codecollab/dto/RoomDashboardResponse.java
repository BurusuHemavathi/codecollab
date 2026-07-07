package com.codecollab.dto;

public class RoomDashboardResponse {

    private String roomCode;
    private Long sheetId;
    private int totalMembers;
    private String leader;
    private int totalCompletedItems;
    private int totalBookmarkedItems;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getTotalCompletedItems() {
        return totalCompletedItems;
    }

    public void setTotalCompletedItems(int totalCompletedItems) {
        this.totalCompletedItems = totalCompletedItems;
    }

    public int getTotalBookmarkedItems() {
        return totalBookmarkedItems;
    }

    public void setTotalBookmarkedItems(int totalBookmarkedItems) {
        this.totalBookmarkedItems = totalBookmarkedItems;
    }
}