package com.vector.notion.notion.dto.boardTask;

import lombok.Data;

@Data
public class BoardTaskRequest {

    private Long boardId;

    private Long taskId;
}
