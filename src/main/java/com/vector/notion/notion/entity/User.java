package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class User {

    private Long id;

    private String userName;

    private String email;

    private String password;

    private Date createdAt;

    private Date updatedAt;

}

