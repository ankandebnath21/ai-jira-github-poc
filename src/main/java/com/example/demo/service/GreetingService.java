package com.example.demo.service;

import com.example.demo.dto.GreetingDto;

public interface GreetingService {
    String getDefaultGreeting();
    GreetingDto getPersonalizedGreeting(String name);
}
