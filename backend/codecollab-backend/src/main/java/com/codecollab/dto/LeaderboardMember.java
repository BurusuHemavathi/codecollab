package com.codecollab.dto;

public class LeaderboardMember {

    private String userEmail;
    private int completedItems;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getCompletedItems() {
        return completedItems;
    }

    public void setCompletedItems(int completedItems) {
        this.completedItems = completedItems;
    }
}