package com.mygreetingsapp.controller;

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

    // Handles GET requests
    @GetMapping
    public GreetingResponse getGreeting() {
        return new GreetingResponse(greetingService.getGreetingMessage(), HttpStatus.OK.value());
    }

    // Handles POST requests
    @PostMapping
    public GreetingResponse postGreeting() {
        return new GreetingResponse(greetingService.postGreetingMessage(), HttpStatus.CREATED.value());
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
