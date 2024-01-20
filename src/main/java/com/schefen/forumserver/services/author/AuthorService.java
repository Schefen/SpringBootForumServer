package com.schefen.forumserver.services.author;

import com.schefen.forumserver.entities.Author;
import com.schefen.forumserver.entities.dtos.AuthorDto;

import java.util.List;


public interface AuthorService {
    List<AuthorDto> getAllAuthors();
}
