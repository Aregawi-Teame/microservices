package com.weone.notification.service;

import com.weone.clients.notification.record.NotificationRequest;
import com.weone.notification.model.Notification;

public interface NotificationService {
    public Notification save(NotificationRequest notificationRequest);
}
