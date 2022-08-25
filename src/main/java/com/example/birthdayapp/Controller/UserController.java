package com.example.birthdayapp.Controller;

import com.example.birthdayapp.model.User;
import com.example.birthdayapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = {"/"})
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PostMapping("/login")
    @ResponseBody
    public Optional<User> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        return userService.login(email, password);
    }

}
