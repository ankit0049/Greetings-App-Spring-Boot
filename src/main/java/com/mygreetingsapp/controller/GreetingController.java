package com.mygreetingsapp.controller;

import com.mygreetingsapp.dto.GreetingRequest;
import com.mygreetingsapp.dto.GreetingResponse;
import com.mygreetingsapp.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting") // Base URL for all endpoints
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Handle GET requests (Default Greeting)
    @GetMapping
    public GreetingResponse getDefaultGreeting() {
        return new GreetingResponse(greetingService.getGreetingMessage(null, null), 200);
    }

    // Handle POST requests (Personalized Greeting)
    @PostMapping
    public GreetingResponse createGreeting(@RequestBody GreetingRequest request) {
        String message = greetingService.getGreetingMessage(request.getFirstName(), request.getLastName());
        return new GreetingResponse(message, 201);
    }

    // Handles PUT requests
    @PutMapping
    public GreetingResponse putGreeting() {
        return new GreetingResponse(greetingService.putGreetingMessage(), HttpStatus.OK.value());
    }

    // Handles DELETE requests
    @DeleteMapping
    public GreetingResponse deleteGreeting() {
        return new GreetingResponse(greetingService.deleteGreetingMessage(), HttpStatus.NO_CONTENT.value());
    }
}
