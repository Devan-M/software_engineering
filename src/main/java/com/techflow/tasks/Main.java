package com.techflow.tasks;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        loginService.register("admin", "1234");

        TaskManager manager = new TaskManager();

        if (loginService.login("admin", "1234")) {
            manager.authenticate(true);
        }

        // Teste com dados inválidos
        manager.addTask(new Task(-1, "", "abc",0)); // deve falhar

        // Teste com dados válidos
        manager.addTask(new Task(1, "Configurar CI", "Criar pipeline no GitHub Actions", 0));
    }
}