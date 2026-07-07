package com.codecollab.dto;

public class GroupMemberProgress {

    private String userEmail;
    private int completedItems;
    private int bookmarkedItems;

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

    public int getBookmarkedItems() {
        return bookmarkedItems;
    }

    public void setBookmarkedItems(int bookmarkedItems) {
        this.bookmarkedItems = bookmarkedItems;
    }
}