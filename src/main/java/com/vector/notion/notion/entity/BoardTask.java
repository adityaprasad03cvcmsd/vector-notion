package com.vector.notion.notion.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BoardTask {

    private Long id;

    private Long boardId;

    private Long taskId;

}