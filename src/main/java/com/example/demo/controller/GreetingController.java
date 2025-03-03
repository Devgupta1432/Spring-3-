package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // PUT request to update an existing greeting
    // Example: curl -X PUT http://localhost:8080/greeting/1 -H "Content-Type: application/json" -d '{"message": "Updated greeting!"}'
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting request) {
        return greetingService.updateGreeting(id, request.getMessage());
    }
}
