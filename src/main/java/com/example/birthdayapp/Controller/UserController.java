package com.example.birthdayapp.Controller;

import com.example.birthdayapp.model.Birthday;
import com.example.birthdayapp.model.User;
import com.example.birthdayapp.service.BirthdayServiceImpl;
import com.example.birthdayapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = {"/"})
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        return userService.login(email, password);
    }



}
