package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
public class Comment {

    private Long id;

    private Long taskId;

    private Long userId;

    private List<Long> mentioned;

    private Long documentId;

    private String content;

    private Date createdAt;

    private Date updatedAt;

}