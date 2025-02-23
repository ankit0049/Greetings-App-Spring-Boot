package com.mygreetingsapp.service;

import com.mygreetingsapp.dto.GreetingRequest;
import com.mygreetingsapp.dto.GreetingResponse;
import com.mygreetingsapp.entity.GreetingMessage;
import com.mygreetingsapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer to handle business logic
@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    // Constructor-based Dependency Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Generate and Save Greeting Message
    public GreetingResponse generateAndSaveGreeting(GreetingRequest request) {
        String message;

        if (request.getFirstName() != null && request.getLastName() != null) {
            message = "Hello, " + request.getFirstName() + " " + request.getLastName() + "!";
        } else if (request.getFirstName() != null) {
            message = "Hello, " + request.getFirstName() + "!";
        } else if (request.getLastName() != null) {
            message = "Hello, " + request.getLastName() + "!";
        } else {
            message = "Hello, World!";
        }

        // Save message in the database
        GreetingMessage greetingMessage = new GreetingMessage(message);
        greetingRepository.save(greetingMessage);

        return new GreetingResponse(message,201);
    }

    // Retrieve All Saved Messages
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }
    // Put Method to  update the data
    public String putGreetingMessage() {
        return "Hello Ankit Rajput, this is a PUT request!";
    }

    // Delete method to delete the data
    public String deleteGreetingMessage() {
        return "Hello Ankit Rajput, this is a DELETE request!";
    }
}
