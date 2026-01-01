package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Criando tarefas
        manager.addTask(new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions"));
        manager.addTask(new Task(2, "Implementar CRUD", "Criar operações básicas"));

        // Listando antes da exclusão
        System.out.println("=== Antes da exclusão ===");
        manager.listTasks().forEach(t -> System.out.println(t.getId() + " - " + t.getTitle()));

        // Deletando tarefa
        boolean removida = manager.deleteTask(1);
        if (removida) {
            System.out.println("Tarefa 1 removida com sucesso!");
        }

        // Listando após exclusão
        System.out.println("=== Após exclusão ===");
        manager.listTasks().forEach(t -> System.out.println(t.getId() + " - " + t.getTitle()));
    }
}