package com.techflow.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private boolean authenticated = false; // controle de login

    // Método para autenticar
    public void authenticate(boolean status) {
        this.authenticated = status;
    }

    // CREATE
    public boolean addTask(Task task) {
        if (!authenticated) {
            System.out.println("Acesso negado! Faça login para criar tarefas.");
            return false;
        }
        tasks.add(task);
        System.out.println("Tarefa criada: " + task.getTitle());
        return true;
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
        if (!authenticated) {
            System.out.println("Acesso negado! Faça login para atualizar tarefas.");
            return false;
        }
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

    // DELETE
    public boolean deleteTask(int id) {
        if (!authenticated) {
            System.out.println("Acesso negado! Faça login para excluir tarefas.");
            return false;
        }
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Tarefa removida: " + task.getTitle());
            return true;
        }
        return false;
    }
}