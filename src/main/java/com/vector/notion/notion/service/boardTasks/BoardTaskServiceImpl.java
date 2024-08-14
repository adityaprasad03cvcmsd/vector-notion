package com.vector.notion.notion.service.boardTasks;

import com.vector.notion.notion.dto.boardTask.BoardTaskRequest;
import com.vector.notion.notion.entity.BoardTask;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardTaskServiceImpl implements BoardTaskService{

    private List<BoardTask> boardTaskList;

    @PostConstruct
    void init(){
        boardTaskList = new ArrayList<>();
    }

    @Override
    public BoardTask addTaskToBoard(BoardTaskRequest req) {
        BoardTask boardTask = BoardTask.builder().id(Long.valueOf(boardTaskList.size())).taskId(req.getTaskId()).boardId(req.getBoardId()).build();
        boardTaskList.add(boardTask);
        return boardTask;
    }

    @Override
    public List<BoardTask> getAllBoardTasks(Long boardId) {
        return boardTaskList.stream().filter(e->e.getBoardId().equals(boardId)).collect(Collectors.toList());
    }
}
