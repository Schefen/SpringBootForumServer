package com.schefen.forumserver.repositories.JWT;


import com.schefen.forumserver.entities.jwt.User;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    @Query("Select user from User user Where user.username Like %:username%")
    Optional<User> findByUsername(@RequestParam String username);

    @Query("Select u.role FROM User u WHERE u.email = :username")
    String findRoleByUsername(@Param("username") String username);  //Username aslında bizim email
}
