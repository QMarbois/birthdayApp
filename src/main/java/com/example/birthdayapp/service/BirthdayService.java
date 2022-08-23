package com.example.birthdayapp.service;

import com.example.birthdayapp.model.Birthday;

import java.util.List;
import java.util.Set;

public interface BirthdayService {
    public List<Birthday> getAllBirthdays();
    public Set<Birthday> getBirthdaysByUserId(Long userId);
    public Birthday save(Birthday birthday);
}
