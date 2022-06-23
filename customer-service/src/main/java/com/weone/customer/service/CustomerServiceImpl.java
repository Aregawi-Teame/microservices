package com.weone.customer.service;

import com.weone.customer.controllers.CustomerRegistrationRequest;
import com.weone.customer.models.Customer;
import com.weone.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        //Builder Pattern
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email not taken
        // todo: store customer in db
        customerRepository.save(customer);
    }
}
