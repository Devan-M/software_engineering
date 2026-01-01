package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Criando tarefas
        manager.addTask(new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions"));
        manager.addTask(new Task(2, "Implementar CRUD", "Criar operações básicas"));

        // READ: listar todas as tarefas
        System.out.println("=== Lista de Tarefas ===");
        manager.listTasks().forEach(t ->
                System.out.println("ID: " + t.getId() + " | Título: " + t.getTitle() + " | Concluída: " + t.isCompleted())
        );

        // READ: buscar tarefa por ID
        Task encontrada = manager.findTaskById(2);
        if (encontrada != null) {
            System.out.println("Tarefa encontrada: " + encontrada.getTitle());
        }
    }
}