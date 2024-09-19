package org.shp.notification_service.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long receiverId;
    private String message;
    private LocalDateTime sentAt;




}
