package com.techflow.tasks;

import com.techflow.tasks.model.User;
import com.techflow.tasks.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        User user = new User("devan", "1234");
        userRepository.save(user);

        User found = userRepository.findByUsername("devan");
        assertNotNull(found);
        assertEquals("devan", found.getUsername());
        assertEquals("1234", found.getPassword());
    }
}