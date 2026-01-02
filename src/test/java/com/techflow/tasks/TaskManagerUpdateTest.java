package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskManagerUpdateTest {

    @Autowired
    private TaskRepository repository;

    @Test
    void testUpdateTask() {
        Task task = new Task("Estudar", "Spring Boot básico", 1);
        Task saved = repository.save(task);

        saved.setDescription("Spring Boot avançado");
        Task updated = repository.save(saved);

        assertEquals("Spring Boot avançado", updated.getDescription());
    }
}