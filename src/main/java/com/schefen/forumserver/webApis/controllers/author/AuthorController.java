package com.schefen.forumserver.webApis.controllers.author;


import com.schefen.forumserver.entities.dtos.AuthorDto;
import com.schefen.forumserver.services.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private  AuthorService authorService;

    @GetMapping("/get-authors")
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

}
