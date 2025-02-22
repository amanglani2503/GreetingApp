package com.example.greetingApplication.controller;

import com.example.greetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET request - Returns a Simple greeting message
    @GetMapping
    public String getGreeting() {
        return greetingService.getGreeting();
    }

    // POST request - Accepts a user-provided message and returns it
    @PostMapping
    public String createGreeting(@RequestBody String message) {
        return greetingService.createGreeting(message);
    }

    // PUT request - Updates the greeting message
    @PutMapping
    public String updateGreeting(@RequestBody String message) {
        return greetingService.updateGreeting(message);
    }

    // DELETE request - Deletes the greeting message
    @DeleteMapping
    public String deleteGreeting() {
        return greetingService.deleteGreeting();
    }
}
