package com.vector.notion.notion.service.board;

import com.vector.notion.notion.dto.board.TaskBoardRequest;
import com.vector.notion.notion.entity.Board;

import java.util.List;

public interface BoardService {

    Board createTaskBoard(TaskBoardRequest req);

    List<Board> getTaskBoardsById(Long userId);
}
