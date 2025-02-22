package com.example.greetingApplication.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private String greetingMessage = "Hello, Welcome to Greeting App!";

    // GET request - Returns a Simple greeting message
    @GetMapping
    public String getGreeting() {
        return greetingMessage;
    }

    // POST request - Accepts a user-provided message and returns it
    @PostMapping
    public String createGreeting(@RequestBody String message) {
        return "Greeting received: " + message;
    }

    // PUT request - Updates the greeting message
    @PutMapping
    public String updateGreeting(@RequestBody String message) {
        this.greetingMessage = message;
        return "Greeting updated successfully!";
    }

    // DELETE request - Deletes the greeting message
    @DeleteMapping
    public String deleteGreeting() {
        this.greetingMessage = "No greeting available.";
        return "Greeting deleted successfully!";
    }
}
