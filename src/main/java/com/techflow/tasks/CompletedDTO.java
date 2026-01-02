package com.techflow.tasks;

public class CompletedDTO {
    private boolean completed;

    // Construtor vazio (necessário para JSON)
    public CompletedDTO() {}

    // Getter e Setter
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}