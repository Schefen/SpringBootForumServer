package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
