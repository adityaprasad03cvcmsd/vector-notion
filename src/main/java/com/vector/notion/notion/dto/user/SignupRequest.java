package com.vector.notion.notion.dto.user;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class SignupRequest extends LoginRequest {

    private String email;
}
