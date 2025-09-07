package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public String getDefaultGreeting() {
        return "Hello World";
    }

    @Override
    public String getGreeting(String name) {
        if (name == null || name.isEmpty()) {
            return getDefaultGreeting();
        }
        return "Hello, " + name;
    }
}

}
