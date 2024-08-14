package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Document {

    private Long id;

    private String uqKey;

    private String title;

    private String content;

    private Long userId;

    private Date createdAt;

    private Date updatedAt;
}
