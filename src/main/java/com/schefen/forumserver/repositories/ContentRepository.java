package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Content;
import com.schefen.forumserver.entities.dtos.ContentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content,Long> {
    @Query("Select c from Content c Where c.contentItself Like %:name%")
    Optional<Content> findByContentName(@RequestParam String name);
}
