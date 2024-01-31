package com.schefen.forumserver.services.user;

import com.schefen.forumserver.entities.dtos.UserDto;
import com.schefen.forumserver.entities.jwt.User;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import com.schefen.forumserver.repositories.JWT.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElseThrow(() -> new NoSuchElementException("User not found with email"));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElseThrow(() -> new NoSuchElementException("User not found with username"));
        return modelMapper.map(user,UserDto.class);
    }
}
