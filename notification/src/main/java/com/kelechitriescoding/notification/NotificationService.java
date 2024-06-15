package com.kelechitriescoding.notification;

import com.kelechitriescoding.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public String send(NotificationRequest notificationRequest){
        log.info("Sending Notification");
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("kelechitriescoding")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
        log.info("Notification sent!!!");
        return "Notification sent!!!";
    }
}
