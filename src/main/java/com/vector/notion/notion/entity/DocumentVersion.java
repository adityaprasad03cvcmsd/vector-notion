package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class DocumentVersion {

    private Long id;

    private String documentUqKey;

    private Long documentId;

    private String description;

    private Date createdAt;
}