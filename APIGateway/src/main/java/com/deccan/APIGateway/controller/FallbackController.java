package com.deccan.APIGateway.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/address")
    public ResponseEntity<Map<String, String>> addressFallback() {
        return serviceUnavailable("Address service is currently unavailable");
    }

    @GetMapping("/employee")
    public ResponseEntity<Map<String, String>> employeeFallback() {
        return serviceUnavailable("Employee service is currently unavailable");
    }

    @GetMapping("/worklocation")
    public ResponseEntity<Map<String, String>> workLocationFallback() {
        return serviceUnavailable("Work location service is currently unavailable");
    }

    private ResponseEntity<Map<String, String>> serviceUnavailable(String message) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of("message", message));
    }
}
