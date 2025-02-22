package com.example.greetingApplication.service;

import com.example.greetingApplication.model.Greeting;
import com.example.greetingApplication.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Save a new greeting message
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    // Find greeting by id
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with ID: " + id));
    }

    // Retrieve all stored greeting messages
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Update an existing greeting message
    public Greeting updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newMessage);
                    return greetingRepository.save(greeting);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with ID: " + id));
    }

    // Delete a greeting by ID
    public void deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with ID: " + id);
        }
        greetingRepository.deleteById(id);
    }
}