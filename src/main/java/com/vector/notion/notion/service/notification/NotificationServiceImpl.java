package com.vector.notion.notion.service.notification;

import com.vector.notion.notion.entity.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService{

    private List<Notification> notificationList;

    @PostConstruct
    void init(){
        notificationList = new ArrayList<>();
    }

    @Override
    public Notification createNotification(String content, Long userId) {
        Notification notification = Notification.builder().id(Long.valueOf(notificationList.size())).createdAt(new Date())
                .isRead(false).content(content).userId(userId).build();
        notificationList.add(notification);
        return notification;
    }

    @Override
    public List<Notification> getAllNotification(Long userId) {
        return notificationList.stream().filter(e->e.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public void updateNotificationAsRead(Long notificationId) {
        for(Notification notification: notificationList){
            if(notification.getId().equals(notificationId)){
                notification.setRead(true);
                return;
            }
        }
    }
}
