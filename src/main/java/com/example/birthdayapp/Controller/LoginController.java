package com.example.birthdayapp.Controller;

import com.example.birthdayapp.model.User;
import com.example.birthdayapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public User getToken(@RequestParam("username") final String username,
                         @RequestParam("password") final String password) {

        return userService.login(username, password);
    }
}
