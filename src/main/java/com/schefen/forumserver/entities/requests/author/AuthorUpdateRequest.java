package com.schefen.forumserver.entities.requests.author;

import lombok.Data;

@Data
public class AuthorUpdateRequest {
    private long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorImage;
    private String authorEmail;
    private String authorPhoneNumber;
    private String authorAge;
}
