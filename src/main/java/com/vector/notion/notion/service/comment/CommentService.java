package com.vector.notion.notion.service.comment;

import com.vector.notion.notion.dto.comment.CommentRequest;
import com.vector.notion.notion.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(CommentRequest request);

    List<Comment> getCommentsByDocumentIdOrTaskId(Long documentId, Long taskId);
}
