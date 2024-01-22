package com.schefen.forumserver.services.author;

import com.schefen.forumserver.entities.dtos.AuthorDto;
import com.schefen.forumserver.entities.requests.author.AuthorCreateRequest;
import com.schefen.forumserver.entities.requests.author.AuthorUpdateRequest;

import java.util.List;


public interface AuthorService {
    List<AuthorDto> getAllAuthors();
    AuthorDto getAuthorByNickname(String nickName);
    AuthorDto createAuthor(AuthorCreateRequest createRequest);
    void updateAuthor(AuthorUpdateRequest updateRequest) throws Exception;
    void deleteAuthor(long id);
}
