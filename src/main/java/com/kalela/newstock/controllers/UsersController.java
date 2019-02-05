package com.kalela.newstock.controllers;

import com.kalela.newstock.models.Users;
import com.kalela.newstock.repositories.UserRepository;
import org.postgresql.util.PSQLException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    String response;
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> usersList() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@Valid @RequestBody Users users) {
        try {
            userRepository.save(users);
        } catch (Exception e) {
            // TODO: Use better handling of this error
            return users.getUsername() + " or " + users.getEmail() +
                    " already in use. Please use a valid username or email.";
        }
        return users.getUsername() + " Registered Successfully.";
    }

//    @PostMapping("/login")
//    public String loginUser(@RequestBody Users users) {
//
//        public Users findByUsername(String username) {
//            return entityManager.find(Users.class, username);
//        }
//        String username = users.getUsername();
//
//        userRepository.findByUsername(username);
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

    @GetMapping("/{id}")
    public Users getSingleUser(@PathVariable("id") Long id) {
        return userRepository.getOne(id);
    }

}
