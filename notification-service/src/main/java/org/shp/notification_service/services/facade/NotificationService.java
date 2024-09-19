package org.shp.notification_service.services.facade;

import org.shp.notification_service.dtos.NotificationDto;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> findByReceiverId(long receiverId);
    void notifyCandidate(String message) ;
    void sendNotification(long userId,String message);
}
