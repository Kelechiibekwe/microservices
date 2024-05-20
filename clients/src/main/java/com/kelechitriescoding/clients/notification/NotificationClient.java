package com.kelechitriescoding.clients.notification;

import com.kelechitriescoding.clients.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping(path = "api/v1/notification")
    String sendNotification(NotificationRequest notificationRequest);
}