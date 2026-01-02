package com.techflow.tasks;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @GetMapping
    public List<Task> listTasks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Task findTask(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        if (repository.existsById(id)) {
            task.setId(id);
            return repository.save(task);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Task updateCompleted(@PathVariable int id, @RequestBody CompletedDTO dto) {
        return repository.findById(id).map(task -> {
            task.setCompleted(dto.isCompleted());
            return repository.save(task);
        }).orElse(null);
    }
}