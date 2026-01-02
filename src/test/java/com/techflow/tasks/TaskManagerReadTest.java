package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerReadTest {

    @Test
    public void testListTasks() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true);

        manager.addTask(new Task(1, "Teste 1", "Descrição 1", 0));
        manager.addTask(new Task(2, "Teste 2", "Descrição 2", 2));

        assertEquals(2, manager.listTasks().size());
    }

    @Test
    public void testFindTaskById() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true);

        Task task = new Task(1, "Teste", "Descrição", 1);
        manager.addTask(task);

        Task encontrada = manager.findTaskById(1);
        assertNotNull(encontrada);
        assertEquals("Teste", encontrada.getTitle());
    }
}