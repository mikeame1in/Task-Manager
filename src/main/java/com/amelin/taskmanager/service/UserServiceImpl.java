package com.amelin.taskmanager.service;

import com.amelin.taskmanager.model.User;
import com.amelin.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository users;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User get(User user) {
        return users.find(user.getUsername()).get();
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return users.save(user);
    }
}
