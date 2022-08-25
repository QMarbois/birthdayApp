package com.example.birthdayapp.service;

import com.example.birthdayapp.model.User;
import com.example.birthdayapp.repository.UserRepository;
import com.example.birthdayapp.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public MyUserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserPrincipal user = new MyUserPrincipal();
        if(user.getUsername() == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }
}
