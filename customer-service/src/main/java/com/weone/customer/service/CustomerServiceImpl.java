package com.weone.customer.service;

import com.weone.customer.record.CustomerRegistrationRequest;
import com.weone.customer.models.Customer;
import com.weone.customer.record.FraudCheckResponse;
import com.weone.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
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
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD-SERVICE/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId()
                );
        if(fraudCheckResponse.isFraudster())
            throw new IllegalStateException("fraudster");
        // todo: send notification
    }
}
