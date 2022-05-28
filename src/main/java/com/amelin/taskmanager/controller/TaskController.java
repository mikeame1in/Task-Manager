package com.amelin.taskmanager.controller;

import com.amelin.taskmanager.model.Task;
import com.amelin.taskmanager.model.User;
import com.amelin.taskmanager.repository.TaskRepository;
import com.amelin.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        User user = userService.getCurrentUser();
        task.setUserId(user.getId());
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        User user = userService.getCurrentUser();
        return taskRepository.findAllByUserId(user.getId());
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @PatchMapping("/tasks/{id}")
    public void mark(@PathVariable Long id,
                     @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }
}
