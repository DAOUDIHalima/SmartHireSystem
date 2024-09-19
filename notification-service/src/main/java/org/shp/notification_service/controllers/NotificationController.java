package org.shp.notification_service.controllers;


import org.shp.notification_service.services.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;


    @PostMapping("/notify")
    public ResponseEntity<String> notifyCandidate(@RequestParam Long userId, @RequestParam String message) {
        notificationService.sendNotification(userId, message);
        return ResponseEntity.ok("Notification sent to user with ID: " + userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<?>> getUserNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.findByReceiverId(userId));
    }

}
