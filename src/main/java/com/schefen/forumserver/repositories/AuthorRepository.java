package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("Select a from Author a Where a.authorNickName LIKE %:nickName%")
    Author getAuthorByNickname(@Param("nickName") String nickName);

}
