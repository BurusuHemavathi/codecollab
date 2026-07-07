package com.codecollab.dto;

import java.util.List;

public class GroupProgressResponse {

    private String roomCode;
    private int totalMembers;
    private int totalCompletedItems;

    private List<GroupMemberProgress> members;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public int getTotalCompletedItems() {
        return totalCompletedItems;
    }

    public void setTotalCompletedItems(int totalCompletedItems) {
        this.totalCompletedItems = totalCompletedItems;
    }

    public List<GroupMemberProgress> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMemberProgress> members) {
        this.members = members;
    }
}