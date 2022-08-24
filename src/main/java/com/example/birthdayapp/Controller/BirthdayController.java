package com.example.birthdayapp.Controller;

import com.example.birthdayapp.model.Birthday;
import com.example.birthdayapp.model.User;
import com.example.birthdayapp.service.BirthdayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class BirthdayController {
    @Autowired
    private BirthdayServiceImpl birthdayService;

    @GetMapping(value = {"/birthdays"})
    public List<Birthday> getBirthdays() {
        return birthdayService.getAllBirthdays();
    }

    @GetMapping(value = {"/{userId}/birthdays"})
    public Set<Birthday> getBirthdaysByUserId(@PathVariable("userId") Long id) {
        return birthdayService.getBirthdaysByUserId(id);
    }





}
