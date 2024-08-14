package com.vector.notion.notion.dto.document;

import lombok.Data;

@Data
public class DocumentRequest {

    private String title;

    private String content;

    private String userId;
}
