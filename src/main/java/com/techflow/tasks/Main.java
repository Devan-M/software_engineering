package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Criando tarefas
        Task t1 = new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions");
        Task t2 = new Task(2, "Implementar CRUD", "Criar operações básicas de tarefas");

        manager.addTask(t1);
        manager.addTask(t2);

        // Listando tarefas criadas
        manager.listTasks().forEach(t ->
                System.out.println("ID: " + t.getId() + " | Título: " + t.getTitle())
        );
    }
}