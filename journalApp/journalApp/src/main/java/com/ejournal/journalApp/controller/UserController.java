package com.ejournal.journalApp.controller;


import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.repository.UserRepository;
import com.ejournal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb=userService.findByUsername(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveEntry(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        try{
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            userRepository.deleteByUserName(userName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //admin can only get access to this
//    @GetMapping
//    public List<User> getAllUser(){
//        return userService.getAll();
//    }
}
