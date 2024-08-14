package com.vector.notion.notion.service.board;

import com.vector.notion.notion.dto.board.TaskBoardRequest;
import com.vector.notion.notion.entity.Board;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private List<Board> taskBoard;

    @PostConstruct
    void init(){
        taskBoard = new ArrayList<>();
    }

    @Override
    public Board createTaskBoard(TaskBoardRequest req) {
        Board board = Board.builder().id(Long.valueOf(taskBoard.size())).createdAt(new Date()).name(req.getName())
                .userId(req.getUserId()).build();
        taskBoard.add(board);
        return board;
    }

    @Override
    public List<Board> getTaskBoardsById(Long userId) {
        return taskBoard.stream().filter(e->e.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
