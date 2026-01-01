package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Criando tarefas
        manager.addTask(new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions"));
        manager.addTask(new Task(2, "Implementar CRUD", "Criar operações básicas"));

        // Atualizando tarefa
        boolean atualizado = manager.updateTask(2, "Implementar CRUD completo", "Adicionar Create, Read, Update, Delete", 2, false);

        if (atualizado) {
            System.out.println("Tarefa 2 atualizada com sucesso!");
        }

        // Listando tarefas após atualização
        manager.listTasks().forEach(t ->
                System.out.println("ID: " + t.getId() + " | Título: " + t.getTitle() + " | Prioridade: " + t.getPriority())
        );
    }
}