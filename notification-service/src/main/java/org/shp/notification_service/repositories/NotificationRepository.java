package org.shp.notification_service.repositories;

import org.shp.notification_service.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReceiverId(long receiverId);

     Notification save(Notification notification);

}
