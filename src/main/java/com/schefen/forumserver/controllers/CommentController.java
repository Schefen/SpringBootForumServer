package com.schefen.forumserver.controllers;

import com.schefen.forumserver.entities.Comment;
import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import com.schefen.forumserver.entities.requests.comment.CommentUpdateRequest;
import com.schefen.forumserver.services.comment.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/get-by-x/{x}")
    public ResponseEntity<List<CommentDto>> commentContainsX(@PathVariable String x){
        return ResponseEntity.ok(commentService.getCommentByContainsX(x));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<CommentDto>> getAll(){
        return ResponseEntity.ok(commentService.getAll());
    }
    @PostMapping("/add-comment")
    public ResponseEntity<CommentDto> addComment(CommentCreateRequest createRequest){
        return ResponseEntity.ok(commentService.addComment(createRequest));
    }
    @PutMapping("/edit-comment")
    public void editComment(CommentUpdateRequest updateRequest) throws Exception {
        commentService.editComment(updateRequest);
    }
    @DeleteMapping("/delete-comment")
    public void deleteComment(long id){
        commentService.deleteComment(id);
    }

}
