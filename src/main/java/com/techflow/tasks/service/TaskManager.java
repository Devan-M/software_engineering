package com.techflow.tasks.service;

import com.techflow.tasks.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private boolean authenticated = false;

    public void authenticate(boolean status) {
        this.authenticated = status;
    }

    public boolean addTask(Task task) {
        if (!authenticated) return false;
        tasks.add(task);
        return true;
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public Task findTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public boolean updateTask(int id, String title, String description, int priority, boolean completed) {
        if (!authenticated) return false;
        Task task = findTaskById(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setPriority(priority);
            task.setCompleted(completed);
            return true;
        }
        return false;
    }

    public boolean deleteTask(int id) {
        if (!authenticated) return false;
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }
}