package com.vector.notion.notion.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Media {

    private Long id;

    private Long documentId;

    private String type;

    private String url;

    private Date createdAt;

}