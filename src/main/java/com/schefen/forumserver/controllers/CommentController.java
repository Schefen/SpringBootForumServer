package com.schefen.forumserver.controllers;

import com.schefen.forumserver.aspect.Authorize;
import com.schefen.forumserver.controllers.reqres.CommentCreateResponse;
import com.schefen.forumserver.entities.Comment;
import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.entities.dtos.UserDto;
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
    @Authorize("USER")
    @GetMapping("/get-by-x/{x}")
    public ResponseEntity<List<CommentDto>> commentContainsX(@PathVariable String x){
        return ResponseEntity.ok(commentService.getCommentByContainsX(x));
    }
    @Authorize("USER")
    @GetMapping("/get-all")
    public ResponseEntity<List<CommentDto>> getAll(){
        return ResponseEntity.ok(commentService.getAll());
    }
    @Authorize("USER")
    @PostMapping("/add-comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentCreateRequest createRequest) throws Exception {
        return ResponseEntity.ok(commentService.addComment(createRequest));
    }
    @Authorize("USER")
    @PutMapping("/edit-comment")
    public void editComment(CommentUpdateRequest updateRequest) throws Exception {
        commentService.editComment(updateRequest);
    }
    @Authorize("ADMIN")
    @DeleteMapping("/delete-comment")
    public void deleteComment(long id){
        commentService.deleteComment(id);
    }

}
