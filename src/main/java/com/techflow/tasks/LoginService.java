package com.techflow.tasks;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private Map<String, String> users = new HashMap<>();

    // Registrar novo usuário
    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Usuário já existe!");
        } else {
            users.put(username, password);
            System.out.println("Usuário registrado com sucesso: " + username);
        }
    }

    // Autenticar usuário
    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        }
        System.out.println("Falha no login. Verifique usuário e senha.");
        return false;
    }
}