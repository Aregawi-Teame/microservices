package com.weone.customer.record;

public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {
}
