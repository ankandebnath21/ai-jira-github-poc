package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dto.GreetingDto;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getDefaultGreeting() {
        return "Hello World";
    }

    @Override
    public GreetingDto getPersonalizedGreeting(String name) {
        return new GreetingDto("Hello, " + name);
    }
}
