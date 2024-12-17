package com.codecats.myFirstProject;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myClass {

    @GetMapping("abc")
    public String sayHello() {
        return "Hello World";
    }
}
