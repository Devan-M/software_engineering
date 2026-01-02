package com.techflow.tasks;

public class Task {
    private int id;
    private String title;
    private String description;
    private int priority;
    private boolean completed;

    // Construtor com prioridade
    public Task(int id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    // Construtor sem prioridade (opcional)
    public Task(int id, String title, String description) {
        this(id, title, description, 0); // prioridade padrão = 0
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(int priority) { this.priority = priority; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}