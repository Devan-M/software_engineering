package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    @Test
    public void testRegisterAndLoginSuccess() {
        LoginService service = new LoginService();
        service.register("user", "pass");
        assertTrue(service.login("user", "pass"));
    }

    @Test
    public void testLoginFail() {
        LoginService service = new LoginService();
        service.register("user", "pass");
        assertFalse(service.login("user", "wrong"));
    }
}