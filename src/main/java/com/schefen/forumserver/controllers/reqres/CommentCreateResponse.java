package com.schefen.forumserver.controllers.reqres;

import lombok.Data;

@Data
public class CommentCreateResponse {
    private String commentItself;
    private String authorUsername;
    private String authorEmail;
    private String contentName;
}
