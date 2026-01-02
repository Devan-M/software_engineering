package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerDeleteTest {

    @Test
    public void testDeleteTask() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true); // necessário
        Task task = new Task(1, "Teste", "Descrição");
        manager.addTask(task);

        boolean removida = manager.deleteTask(1);
        assertTrue(removida);
        assertEquals(0, manager.listTasks().size());
    }

    @Test
    public void testDeleteTaskNotFound() {
        TaskManager manager = new TaskManager();
        boolean removida = manager.deleteTask(99);
        assertFalse(removida);
    }
}