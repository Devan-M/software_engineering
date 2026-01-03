package com.techflow.tasks;

import com.techflow.tasks.model.Task;
import com.techflow.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskManagerDeleteTest {

    @Autowired
    private TaskRepository repository;

    @Test
    void testDeleteTask() {
        Task task = new Task("Apagar tarefa", "Teste de delete", 1);
        Task saved = repository.save(task);

        repository.deleteById(saved.getId());

        assertFalse(repository.findById(saved.getId()).isPresent());
    }
}