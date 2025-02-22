package com.example.greetingApplication.controller;

import com.example.greetingApplication.model.Greeting;
import com.example.greetingApplication.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // POST request - For saving the greeting messages
    @PostMapping
    public Greeting createGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    // GET - fetching greetings by id
    @GetMapping("/id/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // GET request - Fetches all stored greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // PUT request- Updates an existing greeting message
    @PutMapping("/id/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }

    // DELETE - Delete a greeting by ID
    @DeleteMapping("/id/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}