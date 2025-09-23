package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.GreetingService;
import com.example.demo.dto.GreetingDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class HelloController {

    private final GreetingService greetingService;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public GreetingDto hello(@RequestParam(required = false) String name) {
        if (name != null) {
            logger.info("Name parameter provided: {}", name);
            return greetingService.getPersonalizedGreeting(name);
        } else {
            logger.info("No name parameter provided");
            return new GreetingDto(greetingService.getDefaultGreeting());
        }
    }
}
