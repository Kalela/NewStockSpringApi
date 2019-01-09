package com.kalela.newstock.controllers;

import com.kalela.newstock.models.Users;
import com.kalela.newstock.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    String response;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> usersList() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody Users users) {
        userRepository.save(users);
        return users.getUsername() + " Registered Successfully.";
    }

//    @PostMapping("/login")
//    public String loginUser(@RequestBody Users users) {
//        String username = users.getUsername();
////        userRepository.getOne(username);
//
//        if (username != null) {
////            if (currentUser.getPassword() == users.getPassword()) {
////                return "Login Successful, this is your token";
////            }
//            return "woah";
//        } else {
//            response = "User does not exist. Kindly register first.";
//        }
//        return response;
//    }
//
//    @GetMapping("/{id}")
//    public Users getSingleUser(@PathVariable("id") Long id) {
//        return userRepository.getOne(id);
//    }

}
