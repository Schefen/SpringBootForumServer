package com.schefen.forumserver.services.comment;

import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import com.schefen.forumserver.entities.requests.comment.CommentUpdateRequest;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAll();
    List<CommentDto> getCommentByContainsX(String x);
    CommentDto addComment(CommentCreateRequest createRequest);
    void editComment(CommentUpdateRequest updateRequest) throws Exception;
    void deleteComment(long id);
}
