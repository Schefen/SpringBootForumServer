package com.schefen.forumserver.entities.requests.comment;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private String commentItself;
    private String authorUsername;
    private String authorEmail;
    private String contentName;
}
