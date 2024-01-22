package com.schefen.forumserver.entities.requests.author;

import lombok.Data;

@Data
public class AuthorCreateRequest {
    private String authorFirstName;
    private String authorLastName;
    private String authorNickName;
    private String authorEmail;
    private String authorImage;
    private String authorPhoneNumber;
    private String authorAge;
}
