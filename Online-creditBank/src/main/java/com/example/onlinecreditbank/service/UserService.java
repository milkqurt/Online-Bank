package com.example.onlinecreditbank.service;

import com.example.onlinecreditbank.entity.User;
import com.example.onlinecreditbank.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    public void create(UserRepo userRepo){
        User user = new User();
        user.setEmail(userRepo.getEmail());
        user.setPassword(passwordEncoder.encode(userRepo.getPassword()));
        repository.save(user);
    }
}
