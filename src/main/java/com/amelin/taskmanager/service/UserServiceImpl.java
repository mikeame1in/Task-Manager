package com.amelin.taskmanager.service;

import com.amelin.taskmanager.model.User;
import com.amelin.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository users;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        return users.find(principal.getUsername()).orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return users.save(user);
    }
}
