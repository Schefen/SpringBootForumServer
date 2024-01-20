package com.schefen.forumserver.entities.dtos;

import lombok.Data;

@Data
public class AuthorDto {
    private long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorNickName;
    private String authorEmail;
    private String authorImage;
    private String authorPhoneNumber;
    private String authorAge;
}
