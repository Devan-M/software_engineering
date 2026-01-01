package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        // Registrar usuário
        loginService.register("admin", "1234");

        // Tentativa de login
        boolean autenticado = loginService.login("admin", "1234");

        if (autenticado) {
            TaskManager manager = new TaskManager();
            manager.authenticate(true); // habilita CRUD

            // Criar tarefa após login
            manager.addTask(new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions"));
            manager.listTasks().forEach(t -> System.out.println("ID: " + t.getId() + " | " + t.getTitle()));
        }
    }
}