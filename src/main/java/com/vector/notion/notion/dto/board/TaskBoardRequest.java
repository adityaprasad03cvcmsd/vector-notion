package com.vector.notion.notion.dto.board;

import lombok.Data;

@Data
public class TaskBoardRequest {

    private Long userId;

    private String name;
}
