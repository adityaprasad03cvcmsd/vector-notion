package com.vector.notion.notion.dto.comment;

import lombok.Data;

import java.util.List;

@Data
public class CommentRequest {

    private Long taskId;

    private Long userId;

    private List<Long> mentioned;

    private Long documentId;

    private String content;
}
