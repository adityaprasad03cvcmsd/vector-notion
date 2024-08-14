package com.vector.notion.notion.controller.notification;

import com.vector.notion.notion.dto.notification.NotificationRequest;
import com.vector.notion.notion.entity.Notification;
import com.vector.notion.notion.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification/v1")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public ResponseEntity<?>createNotification(@RequestBody NotificationRequest req){
        try{
            Notification notification = notificationService.createNotification(req.getContent(), req.getUserId());
            return ResponseEntity.ok(notification);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{notificationId}")
    public ResponseEntity<?>editNotification(@PathVariable("notificationId")Long notificationId){
        try{
            notificationService.updateNotificationAsRead(notificationId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?>getAllNotification(@RequestHeader("userId")Long userId){
        try{
            List<Notification> notificationList = notificationService.getAllNotification(userId);
            return ResponseEntity.ok(notificationList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
