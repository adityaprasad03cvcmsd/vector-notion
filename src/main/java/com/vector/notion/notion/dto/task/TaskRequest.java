package com.vector.notion.notion.dto.task;

import lombok.Data;

import java.util.Date;

@Data
public class TaskRequest {

    private String title;

    private String message;

    private Long userId;

    private Long assignedTo;

    private Date dueDate;

}
