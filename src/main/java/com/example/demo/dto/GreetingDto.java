package com.example.demo.dto;

public class GreetingDto {
    private final String message;

    public GreetingDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
