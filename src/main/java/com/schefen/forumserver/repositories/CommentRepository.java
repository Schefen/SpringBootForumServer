package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Modifying
    @Query("Select c from Comment c Where c.commentItself Like %:x%")
    List<Comment> getCommentByContainsX(@RequestParam("x") String x);
}
