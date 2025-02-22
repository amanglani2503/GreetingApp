package com.example.greetingApplication.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private String greetingMessage = "Hello World";

    // Method to get a personalized greeting
    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, Mr./Ms. " + lastName + "!";
        }
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
