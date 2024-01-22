package com.schefen.forumserver.entities.dtos;

import lombok.Data;

@Data
public class CommentDto {
    private String commentItself;
    private String authorName;
    private String contentName;
}
