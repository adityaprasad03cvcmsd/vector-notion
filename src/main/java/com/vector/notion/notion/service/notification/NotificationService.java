package com.vector.notion.notion.service.notification;

import com.vector.notion.notion.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(String content, Long userId);

    List<Notification> getAllNotification(Long userId);

    void updateNotificationAsRead(Long notificationId);
}
