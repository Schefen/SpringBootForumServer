package com.schefen.forumserver.repositories.JWT;


import com.schefen.forumserver.entities.jwt.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
}
