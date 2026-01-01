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

    // READ
    public List<Task> listTasks() {
        return tasks;
    }

    public Task findTaskById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateTask(int id, String newTitle, String newDescription, int newPriority, boolean completed) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setPriority(newPriority);
            task.setCompleted(completed);
            System.out.println("Tarefa atualizada: " + task.getTitle());
            return true;
        }
        return false;
    }

    // DELETE: remove tarefa pelo ID
    public boolean deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Tarefa removida: " + task.getTitle());
            return true;
        }
        return false;
    }
}