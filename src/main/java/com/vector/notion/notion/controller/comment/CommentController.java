package com.vector.notion.notion.controller.comment;

import com.vector.notion.notion.dto.comment.CommentRequest;
import com.vector.notion.notion.entity.Comment;
import com.vector.notion.notion.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment/v1")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody CommentRequest commentRequest){
        try {
            Comment comment = commentService.createComment(commentRequest);
            return ResponseEntity.ok(comment);
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllComment(@RequestParam(name = "documentId", required = false)Long documentId, @RequestParam(name = "taskId", required = false)Long taskId){
        try {
            List<Comment> comments = commentService.getCommentsByDocumentIdOrTaskId(documentId, taskId);
            return ResponseEntity.ok(comments);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
