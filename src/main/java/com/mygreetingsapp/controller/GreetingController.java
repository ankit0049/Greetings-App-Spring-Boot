package com.mygreetingsapp.controller;

import com.mygreetingsapp.dto.GreetingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public GreetingResponse getGreeting() {
        return new GreetingResponse("Hello Ankit Rajput, this is a GET request!", HttpStatus.OK.value());
    }

    @PostMapping
    public GreetingResponse postGreeting() {
        return new GreetingResponse("Hello Ankit Rajput, this is a POST request!", HttpStatus.CREATED.value());
    }

    @PutMapping
    public GreetingResponse putGreeting() {
        return new GreetingResponse("Hello Ankit Rajput, this is a PUT request!", HttpStatus.OK.value());
    }

    @DeleteMapping
    public GreetingResponse deleteGreeting() {
        return new GreetingResponse("Hello Ankit Rajput, this is a DELETE request!", HttpStatus.NO_CONTENT.value());
    }
}
