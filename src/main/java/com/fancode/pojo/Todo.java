package com.fancode.pojo;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {  // Ensure this getter exists
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
