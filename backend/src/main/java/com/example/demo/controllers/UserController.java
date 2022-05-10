package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") final long userID) {
        return userService.find(userID);
    }

    @PostMapping("")
    public void createUser(@RequestBody final User user) {
        userService.create(user);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable(value = "id") final long userID,
                                 @RequestBody final User user) {
        userService.update(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") final long userID) {
        userService.delete(userID);
    }
}