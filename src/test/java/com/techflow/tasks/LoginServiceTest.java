package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    void testRegisterAndLoginSuccess() {
        // registra o usuário
        boolean registered = loginService.register("user", "pass");
        assertTrue(registered);

        // tenta logar com a mesma senha
        boolean loggedIn = loginService.login("user", "pass");
        assertTrue(loggedIn);
    }

    @Test
    void testLoginFail() {
        // registra o usuário
        loginService.register("user", "pass");

        // tenta logar com senha incorreta
        assertFalse(loginService.login("user", "wrong"));
    }
}