package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Notification {

    private Long id;

    private Long userId;

    private String content;

    private Date createdAt;

    private boolean isRead;

}
