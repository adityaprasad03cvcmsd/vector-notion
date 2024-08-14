package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Board {

    private Long id;

    private String name;

    private Long userId;

    private Date createdAt;

    private Date updatedAt;
}
