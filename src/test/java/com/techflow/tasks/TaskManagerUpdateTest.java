package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerUpdateTest {

    @Test
    public void testUpdateTask() {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task(1, "Teste", "Descrição"));

        boolean atualizado = manager.updateTask(1, "Novo título", "Nova descrição", 3, true);

        assertTrue(atualizado);
        Task task = manager.findTaskById(1);
        assertEquals("Novo título", task.getTitle());
        assertEquals("Nova descrição", task.getDescription());
        assertEquals(3, task.getPriority());
        assertTrue(task.isCompleted());
    }

    @Test
    public void testUpdateTaskNotFound() {
        TaskManager manager = new TaskManager();
        boolean atualizado = manager.updateTask(99, "Título", "Descrição", 1, false);
        assertFalse(atualizado);
    }
}