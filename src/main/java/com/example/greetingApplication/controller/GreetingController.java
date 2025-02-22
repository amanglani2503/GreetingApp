package com.example.greetingApplication.controller;

import com.example.greetingApplication.model.Greeting;
import com.example.greetingApplication.service.GreetingService;
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
}
