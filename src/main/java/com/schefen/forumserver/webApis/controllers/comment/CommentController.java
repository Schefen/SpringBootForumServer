package com.schefen.forumserver.webApis.controllers.comment;

import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.services.comment.CommentService;
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
}
