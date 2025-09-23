package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.GreetingService;
import com.example.demo.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public Greeting hello(@RequestParam(required = false) String name) {
        logger.info("Name parameter provided: {}", name != null);
        if (name != null) {
            return greetingService.getPersonalizedGreeting(name);
        } else {
            return greetingService.getDefaultGreeting();
        }
    }
}
