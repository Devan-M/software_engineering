package com.techflow.tasks;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int priority; // campo para mudança de escopo

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.priority = 0;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public int getPriority() { return priority; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setPriority(int priority) { this.priority = priority; }
}