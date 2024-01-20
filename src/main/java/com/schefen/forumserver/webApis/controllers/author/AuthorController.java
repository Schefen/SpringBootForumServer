package com.schefen.forumserver.webApis.controllers.author;


import com.schefen.forumserver.entities.dtos.AuthorDto;
import com.schefen.forumserver.services.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private  AuthorService authorService;

    @GetMapping("/get-all")
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/get-by-nickname/{nickName}")
    public ResponseEntity<AuthorDto> getByNickName(@PathVariable String nickName){
        AuthorDto authorDto = authorService.getAuthorByNickname(nickName);
        return (authorDto != null) ? ResponseEntity.ok(authorDto) : ResponseEntity.notFound().build();
    }
    @PostMapping("/add-author")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto createdAuthor = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }
}
