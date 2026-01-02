package com.techflow.tasks;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskManager manager = new TaskManager();

    public TaskController() {
        manager.authenticate(true); // habilita CRUD
    }

    @PostMapping
    public boolean addTask(@RequestBody Task task) {
        return manager.addTask(task);
    }

    @GetMapping
    public List<Task> listTasks() {
        return manager.listTasks();
    }

    @GetMapping("/{id}")
    public Task findTask(@PathVariable int id) {
        return manager.findTaskById(id);
    }

    @PutMapping("/{id}")
    public boolean updateTask(@PathVariable int id, @RequestBody Task task) {
        return manager.updateTask(id, task.getTitle(), task.getDescription(),
                task.getPriority(), task.isCompleted());
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable int id) {
        return manager.deleteTask(id);
    }

    @GetMapping("/")
    public String home() {
        return "API de Gerenciamento de Tarefas está rodando!";
    }
}