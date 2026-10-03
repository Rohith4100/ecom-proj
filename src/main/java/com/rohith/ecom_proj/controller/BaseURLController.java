package com.rohith.ecom_proj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseURLController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("E-Commerce Backend is running");
    }
}