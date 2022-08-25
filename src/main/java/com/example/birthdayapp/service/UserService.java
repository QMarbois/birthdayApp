package com.example.birthdayapp.service;

import com.example.birthdayapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User login(String email, String password);
    public User getUserById(Long id);
    public List<User> getAllUsers();
    public User save(User user);
}
