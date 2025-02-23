package com.mygreetingsapp.service;

import org.springframework.stereotype.Service;

// Service layer to handle business logic
@Service
public class GreetingService {
    // Created a method to get the Greeting message with the given name
    public String getGreetingMessage(String firstName, String lastName) {
        // If both first name & last name are provided
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        }
        // If only first name is provided
        else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName + "!";
        }
        // If only last name is provided
        else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, " + lastName + "!";
        }
        // If neither is provided, return default message
        return "Hello, World!";
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
