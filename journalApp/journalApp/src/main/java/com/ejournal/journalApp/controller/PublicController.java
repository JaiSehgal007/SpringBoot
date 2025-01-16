package com.ejournal.journalApp.controller;

import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //the special thing about this Component (restController) is that, all the returns of the endpoint in it automatically gets converted into json
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            Optional<User> dbUser = userService.saveNewUser(user);
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
}
