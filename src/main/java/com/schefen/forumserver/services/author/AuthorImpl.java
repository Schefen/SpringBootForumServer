package com.schefen.forumserver.services.author;
import com.schefen.forumserver.entities.Author;
import com.schefen.forumserver.entities.dtos.AuthorDto;
import com.schefen.forumserver.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> modelMapper.map(author, AuthorDto.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorByNickname(String nickName) {
        Author author = authorRepository.getAuthorByNickname(nickName);
        return (author != null) ? modelMapper.map(author,AuthorDto.class) : null;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }
}
