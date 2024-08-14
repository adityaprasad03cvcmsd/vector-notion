package com.vector.notion.notion.dto.user;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class LoginRequest {

    private String userName;

    private String password;
}
