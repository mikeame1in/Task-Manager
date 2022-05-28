package com.amelin.taskmanager.service;

import com.amelin.taskmanager.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User getCurrentUser();
    User create(User user);
}
