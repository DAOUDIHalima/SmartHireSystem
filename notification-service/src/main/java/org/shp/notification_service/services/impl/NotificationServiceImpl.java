package org.shp.notification_service.services.impl;

import org.modelmapper.ModelMapper;
import org.shp.notification_service.dtos.CandidateDto;
import org.shp.notification_service.dtos.NotificationDto;
import org.shp.notification_service.dtos.UserDto;
import org.shp.notification_service.feign.UserClient;
import org.shp.notification_service.models.Notification;
import org.shp.notification_service.repositories.NotificationRepository;
import org.shp.notification_service.services.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    private  UserClient userClient;
    private  KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "job_notifications";



    @Override
    public List<NotificationDto> findByReceiverId(long receiverId) {
        List<Notification> notifications = notificationRepository.findByReceiverId(receiverId);
        List<NotificationDto> notificationDtos = new ArrayList<>();
        for (Notification notification : notifications) {
            notificationDtos.add(modelMapper.map(notification, NotificationDto.class));
        }
        return notificationDtos;
    }


    public void sendNotification(long userId,String message) {
        NotificationDto notificationDto = new NotificationDto(userId,message, LocalDateTime.now());
        notificationRepository.save(modelMapper.map(notificationDto,Notification.class));
        kafkaTemplate.send(TOPIC, message);
    }

    public void notifyCandidate(String message) {
        List<CandidateDto> candidates =userClient.getAllCandidates();
        for (CandidateDto candidateDto : candidates) {
            sendNotification(candidateDto.getId(),message);
        }
    }




}
