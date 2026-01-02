package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskManagerCreateTest {

    @Autowired
    private TaskRepository repository;

    @Test
    void testCreateTask() {
        Task task = new Task("Estudar Spring", "Aprender JPA e H2", 3);
        Task saved = repository.save(task);

        assertNotNull(saved.getId()); // ID gerado pelo banco
        assertEquals("Estudar Spring", saved.getTitle());
    }
}