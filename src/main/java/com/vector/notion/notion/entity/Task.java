package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Task {

    private Long id;

    private String title;

    private String description;

    private String status;

    private Long userId;

    private Long assignedTo;

    private Date dueDate;

    private Date createdAt;

    private Date updatedAt;

}
