package com.techflow.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void testAddTask() {
        TaskManager manager = new TaskManager();
        manager.authenticate(true); // habilita CRUD

        Task task = new Task(1, "Teste", "Descrição da tarefa", 1);
        manager.addTask(task);

        assertEquals(1, manager.listTasks().size());
    }
}