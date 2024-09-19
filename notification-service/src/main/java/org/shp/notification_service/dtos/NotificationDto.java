package org.shp.notification_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDto {

    private long id;

    private long receiverId;
    private String message;
    private LocalDateTime sentAt;


    public NotificationDto() {

    }

    public NotificationDto(long receiverId, String message, LocalDateTime sentAt) {
        this.receiverId = receiverId;
        this.message = message;
        this.sentAt = sentAt;

    }
}
