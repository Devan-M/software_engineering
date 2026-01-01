package com.techflow.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    // CREATE
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Tarefa criada: " + task.getTitle());
    }

    // READ: lista todas as tarefas
    public List<Task> listTasks() {
        return tasks;
    }

    // READ: busca tarefa por ID
    public Task findTaskById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}