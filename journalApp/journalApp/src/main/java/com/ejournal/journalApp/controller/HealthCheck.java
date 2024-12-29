package com.ejournal.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //the special thing about this Component (restController) is that, all the returns of the endpoint in it automatically gets converted into json
public class HealthCheck {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }
}
