package com.kelechitriescoding.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
