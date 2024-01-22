package com.schefen.forumserver.entities.requests.comment;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private String commentItself;
    private String authorName;
    private String contentName;
}
