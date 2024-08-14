package com.vector.notion.notion.service.boardTasks;

import com.vector.notion.notion.dto.boardTask.BoardTaskRequest;
import com.vector.notion.notion.entity.BoardTask;

import java.util.List;

public interface BoardTaskService {

    BoardTask addTaskToBoard(BoardTaskRequest req);

    List<BoardTask> getAllBoardTasks(Long boardId);
}
