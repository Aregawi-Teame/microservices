package com.weone.clients.notification.record;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
) {
}