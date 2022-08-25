package com.example.birthdayapp.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Birthday {

    public Birthday() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Birthday(Long id, LocalDate date, String firstname, String lastname, User user) {
        super();
        this.id = id;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
