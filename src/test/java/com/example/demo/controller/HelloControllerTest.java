package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.service.GreetingService;
import com.example.demo.dto.GreetingDto;

class HelloControllerTest {

    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHelloWithName() {
        String name = "John";
        GreetingDto expectedGreeting = new GreetingDto("Hello, John!");
        when(greetingService.getPersonalizedGreeting(name)).thenReturn(expectedGreeting);

        GreetingDto result = helloController.hello(name);

        assertEquals(expectedGreeting, result);
    }

    @Test
    void testHelloWithoutName() {
        String defaultGreeting = "Hello, World!";
        when(greetingService.getDefaultGreeting()).thenReturn(defaultGreeting);

        GreetingDto result = helloController.hello(null);

        assertEquals(new GreetingDto(defaultGreeting), result);
    }
}
