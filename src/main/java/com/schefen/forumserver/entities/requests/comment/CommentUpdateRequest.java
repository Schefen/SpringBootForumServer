package com.schefen.forumserver.entities.requests.comment;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private long commentId;
    private String commentItself;
}
