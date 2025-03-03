package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // curl -X GET "http://localhost:8080/greeting/?name=John"
    @GetMapping("/")
    public String getGreeting(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + " from GET method!";
    }

    // curl -X POST http://localhost:8080/greeting/ -H "Content-Type: application/json" -d '{"message": "Hello, Spring!"}'
    @PostMapping("/")
    public String postGreeting(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        return "Received message: " + message;
    }

    // curl -X PUT http://localhost:8080/greeting/ -H "Content-Type: application/json" -d '{"updatedMessage": "Updated greeting!"}'
    @PutMapping("/")
    public String putGreeting(@RequestBody Map<String, String> request) {
        String updatedMessage = request.get("updatedMessage");
        return "Greeting updated to: " + updatedMessage;
    }

    // curl -X DELETE "http://localhost:8080/greeting/?id=123"
    @DeleteMapping("/")
    public String deleteGreeting(@RequestParam(name = "id") int id) {
        return "Greeting with ID " + id + " has been deleted.";
    }

    // New method using GreetingService
    @GetMapping("/simple")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }
}
