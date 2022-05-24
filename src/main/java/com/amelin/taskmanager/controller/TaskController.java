package com.amelin.taskmanager.controller;

import com.amelin.taskmanager.model.Task;
import com.amelin.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> get() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }
}
