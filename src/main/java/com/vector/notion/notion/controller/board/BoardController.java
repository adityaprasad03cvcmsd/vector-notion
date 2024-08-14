package com.vector.notion.notion.controller.board;

import com.vector.notion.notion.dto.board.TaskBoardRequest;
import com.vector.notion.notion.dto.boardTask.BoardTaskRequest;
import com.vector.notion.notion.entity.Board;
import com.vector.notion.notion.entity.BoardTask;
import com.vector.notion.notion.service.boardTasks.BoardTaskService;
import com.vector.notion.notion.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/v1")
public class BoardController {

    @Autowired
    BoardTaskService boardTaskService;

    @Autowired
    BoardService boardService;

    @PostMapping
    public ResponseEntity<?> createBoard(TaskBoardRequest request){
        try {
            Board board = boardService.createTaskBoard(request);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBoards(@RequestHeader("userId")Long userId){
        try{
            List<Board> boards = boardService.getTaskBoardsById(userId);
            return ResponseEntity.ok(boards);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/task")
    public ResponseEntity<?> addTasksToBoard(@RequestBody BoardTaskRequest request){
        try{
            BoardTask boardTask = boardTaskService.addTaskToBoard(request);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/task")
    public ResponseEntity<?>getAllTaskONBoard(@RequestParam("boardId") Long boardId){
        try{
            List<BoardTask> boardTask = boardTaskService.getAllBoardTasks(boardId);
            return ResponseEntity.ok(boardTask);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
