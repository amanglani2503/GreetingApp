package com.example.greetingApplication.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private String greetingMessage = "Hello World";

    public String getGreeting() {
        return greetingMessage;
    }

    public String createGreeting(String message) {
        return "Greeting received: " + message;
    }

    public String updateGreeting(String message) {
        this.greetingMessage = message;
        return "Greeting updated successfully!";
    }

    public String deleteGreeting() {
        this.greetingMessage = "No greeting available.";
        return "Greeting deleted successfully!";
    }
}
