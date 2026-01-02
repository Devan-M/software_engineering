package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskManagerReadTest {

    @Autowired
    private TaskRepository repository;

    @Test
    void testFindTaskById() {
        Task task = new Task("Fazer commit", "Fechar issue #11", 2);
        Task saved = repository.save(task);

        Task found = repository.findById(saved.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("Fazer commit", found.getTitle());
    }
}