package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Permission {

    private Long id;

    private Long documentId;

    private Long userId;

    private String type; // read, write, admin

    private Date createdAt;

}
