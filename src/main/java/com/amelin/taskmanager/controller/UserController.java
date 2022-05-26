package com.amelin.taskmanager.controller;

import com.amelin.taskmanager.model.User;
import com.amelin.taskmanager.repository.UserRepository;
import com.amelin.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public User get(@RequestBody User user) {
         return userService.get(user);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
