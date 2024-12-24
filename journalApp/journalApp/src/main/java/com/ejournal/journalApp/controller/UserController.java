package com.ejournal.journalApp.controller;


import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            Optional<User> dbUser = userService.saveEntry(user);
            if(dbUser.isPresent()){
                return new ResponseEntity<>(dbUser.get(), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>("Username already exist", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{userName}")
    public ResponseEntity<?> updateUser(@PathVariable String userName,@RequestBody User user){
        User userInDb=userService.findByUsername(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
