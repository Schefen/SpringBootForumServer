package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,Long> {
}
