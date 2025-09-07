package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.service.GreetingService;
import com.example.demo.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

    private final GreetingService greetingService;
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public ResponseEntity<Greeting> hello(@RequestParam(required = false) String name) {
        logger.info("Name parameter provided: {}", StringUtils.hasText(name));
        String message = greetingService.getGreeting(name);
        return ResponseEntity.ok(new Greeting(message));
    }
}

