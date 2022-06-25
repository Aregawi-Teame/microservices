package com.weone.clients.notification;

import com.weone.clients.notification.record.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification-service")
public interface NotificationClient {
    @PostMapping("api/v1/notifications")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
