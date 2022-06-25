package com.weone.notification.service;

import com.weone.clients.notification.record.NotificationRequest;
import com.weone.notification.model.Notification;
import com.weone.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{
    private final NotificationRepository notificationRepository;
    @Override
    public Notification save(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build();
        return notificationRepository.save(notification);
    }
}
