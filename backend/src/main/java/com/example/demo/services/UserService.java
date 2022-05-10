package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> find(final long id) {
        return userRepository.findById(id);
    }

    public void create(final User user) {
        userRepository.save(user);
    }

    public void update(final User user) {
        User update = userRepository.findById(user.getUserId()).orElseThrow();
        update.setUsername(user.getUsername());
        update.setPassword(user.getPassword());
        update.setRole(user.getRole());
        userRepository.save(user);
    }

    public void delete(final long id) {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }

}