package com.techflow.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    // CREATE: adiciona nova tarefa
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Tarefa criada: " + task.getTitle());
    }

    // READ: lista todas as tarefas
    public List<Task> listTasks() {
        return tasks;
    }
}