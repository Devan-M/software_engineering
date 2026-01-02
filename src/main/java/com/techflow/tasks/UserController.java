package com.techflow.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private LoginService loginService;

    // Endpoint de registro
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean success = loginService.register(user.getUsername(), user.getPassword());
        if (success) {
            return ResponseEntity.ok("Usuário registrado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
    }

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean success = loginService.login(user.getUsername(), user.getPassword());
        if (success) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Falha no login. Verifique usuário e senha.");
        }
    }
}