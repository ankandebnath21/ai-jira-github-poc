package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getDefaultGreeting() {
        return "Hello World";
    }

    @Override
    public String getGreeting(String name) {
        if (StringUtils.hasText(name)) {
            return String.format("Hello, %s", name);
        } else {
            return getDefaultGreeting();
        }
    }
}
