package com.example.birthdayapp.repository;

import com.example.birthdayapp.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthdayRepository extends JpaRepository<Birthday, Long> {

}
