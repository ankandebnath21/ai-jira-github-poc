package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthStatus health() {
        return new HealthStatus("UP");
    }

    private static class HealthStatus {
        public String status;

        public HealthStatus(String status) { this.status = status; }
    }
}
