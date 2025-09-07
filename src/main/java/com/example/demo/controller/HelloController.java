package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
    
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, Jira-AI Integration";
    }
}
}
