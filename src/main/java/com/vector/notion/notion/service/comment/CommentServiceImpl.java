package com.vector.notion.notion.service.comment;

import com.vector.notion.notion.dto.comment.CommentRequest;
import com.vector.notion.notion.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private List<Comment> commentList;

    void init(){
        commentList = new ArrayList<>();
    }

    @Override
    public Comment createComment(CommentRequest request) {
        Comment comment = Comment.builder().createdAt(new Date()).id(Long.valueOf(commentList.size()))
                .mentioned(request.getMentioned()).content(request.getContent()).documentId(request.getDocumentId())
                .taskId(request.getTaskId()).userId(request.getUserId()).build();

        commentList.add(comment);
        return comment;
    }

    @Override
    public List<Comment> getCommentsByDocumentIdOrTaskId(Long documentId, Long taskId) {
        if(documentId!=null){
            return commentList.stream().filter(e->e.getDocumentId().equals(documentId)).collect(Collectors.toList());
        }

        if(taskId!=null){
            return commentList.stream().filter(e->e.getTaskId().equals(taskId)).collect(Collectors.toList());
        }

        return null;
    }
}
