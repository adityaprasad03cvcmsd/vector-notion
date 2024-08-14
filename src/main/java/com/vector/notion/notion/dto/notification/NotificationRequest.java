package com.vector.notion.notion.dto.notification;

import lombok.Data;

@Data
public class NotificationRequest {

    private Long userId;

    private String content;
}
