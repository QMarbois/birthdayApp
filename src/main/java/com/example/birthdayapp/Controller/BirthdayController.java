package com.example.birthdayapp.Controller;

import com.example.birthdayapp.model.Birthday;
import com.example.birthdayapp.model.User;
import com.example.birthdayapp.service.BirthdayServiceImpl;
import com.example.birthdayapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class BirthdayController {
    @Autowired
    private BirthdayServiceImpl birthdayService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = {"/birthdays"})
    public List<Birthday> getBirthdays() {
        return birthdayService.getAllBirthdays();
    }

    @GetMapping(value = {"/{userId}/birthdays"})
    public Set<Birthday> getBirthdaysByUserId(@PathVariable("userId") Long id) {
        return birthdayService.getBirthdaysByUserId(id);
    }

    @PostMapping("/{userId}/birthdays")
    public ResponseEntity<Birthday> createBirthday(
            @PathVariable("userId") Long id,
            @RequestParam("firstname") final String firstname,
            @RequestParam("lastname") final String lastname,
            @RequestParam("date") final String date) {
        try {
            User user = userService.getUserById(id);
            Birthday birthday = new Birthday(null, LocalDate.parse(date), firstname, lastname, user);

            return ResponseEntity.ok(birthdayService.save(birthday));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }




}
