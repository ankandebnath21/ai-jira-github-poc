package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GreetingService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello() {
        // Simple controller returning a static message for POC
        return greetingService.getDefaultGreeting();
    }
}
