package com.weone.fraud.service;

import com.weone.fraud.model.FraudCheckHistory;
import com.weone.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements  FraudCheckService{

    private final  FraudCheckHistoryRepository checkHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        checkHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
