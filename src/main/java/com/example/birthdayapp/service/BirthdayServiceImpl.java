package com.example.birthdayapp.service;

import com.example.birthdayapp.model.Birthday;
import com.example.birthdayapp.model.User;
import com.example.birthdayapp.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class BirthdayServiceImpl implements BirthdayService{
    @Autowired
    private BirthdayRepository birthdayRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Birthday> getAllBirthdays() {
        return birthdayRepository.findAll();
    }

    @Override
    public Set<Birthday> getBirthdaysByUserId(Long userId) {
        Optional<User> user = userService.getUserById(userId);
        //TODO check with master Bardu
        if (user.isEmpty()){
            throw new NoSuchElementException();
        }
        return user.get().getBirthdays();
    }

    @Override
    public Birthday save(Birthday birthday) {
        return birthdayRepository.save(birthday);
    }
}
