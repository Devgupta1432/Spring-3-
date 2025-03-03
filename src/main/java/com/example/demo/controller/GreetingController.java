package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET request to fetch all greetings from the database
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // POST request to save a new greeting
    // curl -X POST http://localhost:8080/greeting -H "Content-Type: application/json" -d '{"message": "Hello, Spring!"}'
    @PostMapping
    public Greeting postGreeting(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        return greetingService.saveGreeting(message);
    }

    // Simple greeting
    @GetMapping("/simple")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }
}
