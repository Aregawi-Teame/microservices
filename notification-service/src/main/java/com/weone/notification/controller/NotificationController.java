package com.weone.notification.controller;

import com.weone.clients.notification.record.NotificationRequest;
import com.weone.notification.model.Notification;
import com.weone.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public void save(@RequestBody NotificationRequest notificationRequest){
        log.info("Notification requested to customer ", notificationRequest);
        notificationService.save(notificationRequest);
    }
}
