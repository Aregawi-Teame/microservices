package com.weone.fraud.controller;

import com.weone.clients.fraud.record.FraudCheckResponse;
import com.weone.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;
    @GetMapping(path ="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
