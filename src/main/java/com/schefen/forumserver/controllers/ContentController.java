package com.schefen.forumserver.controllers;

import com.schefen.forumserver.aspect.Authorize;
import com.schefen.forumserver.entities.dtos.ContentDto;
import com.schefen.forumserver.services.content.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @Authorize("USER")
    @GetMapping("/get-all-page-contents")
    public ResponseEntity<Page<ContentDto>> getContents(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<ContentDto> contents = contentService.getAllContents(pageable);
        return ResponseEntity.ok(contents);
    }

}
