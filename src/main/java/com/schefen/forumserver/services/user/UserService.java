package com.schefen.forumserver.services.user;

import com.schefen.forumserver.entities.dtos.UserDto;

public interface UserService {
    UserDto findByEmail(String email);
    UserDto findByUsername(String username);
}
