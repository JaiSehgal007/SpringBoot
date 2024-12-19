package com.codecats.myFirstProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myClass {

    @Autowired // this is known as dependency injection ( myClass is dependant on Dog)
    private Dog dog; // we need not write new (this is field injection)
    // we asked for a object (bean)

    @GetMapping("abc")
    public String sayHello() {
        return dog.fun();
    }
}

/*
* this @RestController also make a bean only
* but is is a something more than @Component
* */