package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerDeleteTest {

    @Test
    public void testDeleteTask() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true);

        Task task = new Task(1, "Teste", "Descrição", 1);
        manager.addTask(task);

        boolean removida = manager.deleteTask(1);
        assertTrue(removida);
        assertEquals(0, manager.listTasks().size());
    }

    @Test
    public void testDeleteTaskNotFound() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true);

        boolean removida = manager.deleteTask(99);
        assertFalse(removida);
    }
}