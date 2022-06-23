package com.weone.customer.controllers;

public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {
}
