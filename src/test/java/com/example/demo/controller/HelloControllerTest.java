package com.example.demo.controller;

import com.example.demo.dto.GreetingDto;
import com.example.demo.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HelloControllerTest {

    @Mock
    private GreetingService greetingService;

    private HelloController helloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        helloController = new HelloController(greetingService);
    }

    @Test
    void testHelloWithName() {
        String name = "John";
        GreetingDto expectedGreeting = new GreetingDto("Hello, John");
        when(greetingService.getPersonalizedGreeting(name)).thenReturn(expectedGreeting);

        GreetingDto result = helloController.hello(name);

        assertEquals(expectedGreeting, result);
        verify(greetingService).getPersonalizedGreeting(name);
    }

    @Test
    void testHelloWithoutName() {
        String defaultGreeting = "Hello World";
        when(greetingService.getDefaultGreeting()).thenReturn(defaultGreeting);

        GreetingDto result = helloController.hello(null);

        assertEquals(defaultGreeting, result.getMessage());
        verify(greetingService).getDefaultGreeting();
        verify(greetingService, never()).getPersonalizedGreeting(any());
    }
}
