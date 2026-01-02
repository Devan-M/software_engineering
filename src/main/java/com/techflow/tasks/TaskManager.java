package com.techflow.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private boolean authenticated = false;

    public void authenticate(boolean status) {
        this.authenticated = status;
    }

    // Validação de entradas
    private boolean validateTask(Task task) {
        if (task.getId() <= 0) {
            System.out.println("Erro: ID deve ser positivo.");
            return false;
        }
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            System.out.println("Erro: título não pode ser vazio.");
            return false;
        }
        if (task.getDescription() == null || task.getDescription().length() < 5) {
            System.out.println("Erro: descrição deve ter pelo menos 5 caracteres.");
            return false;
        }
        if (task.getPriority() < 0 || task.getPriority() > 2) {
            System.out.println("Erro: prioridade inválida (use 0, 1 ou 2).");
            return false;
        }
        // Verifica se já existe uma tarefa com o mesmo ID
        if (findTaskById(task.getId()) != null) {
            System.out.println("Erro: já existe uma tarefa com esse ID.");
            return false;
        }
        return true;
    }

    // CREATE
    public boolean addTask(Task task) {
        if (!authenticated) {
            System.out.println("Acesso negado! Faça login para criar tarefas.");
            return false;
        }
        if (!validateTask(task)) {
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
        if (task == null) {
            System.out.println("Erro: tarefa não encontrada.");
            return false;
        }
        if (newTitle == null || newTitle.trim().isEmpty()) {
            System.out.println("Erro: título não pode ser vazio.");
            return false;
        }
        if (newDescription == null || newDescription.length() < 5) {
            System.out.println("Erro: descrição deve ter pelo menos 5 caracteres.");
            return false;
        }
        if (newPriority < 0 || newPriority > 2) {
            System.out.println("Erro: prioridade inválida.");
            return false;
        }

        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setPriority(newPriority);
        task.setCompleted(completed);
        System.out.println("Tarefa atualizada: " + task.getTitle());
        return true;
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
        System.out.println("Erro: tarefa não encontrada.");
        return false;
    }
}