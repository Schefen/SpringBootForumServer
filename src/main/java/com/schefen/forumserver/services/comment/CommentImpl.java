package com.schefen.forumserver.services.comment;

import com.schefen.forumserver.controllers.reqres.CommentCreateResponse;
import com.schefen.forumserver.entities.Comment;
import com.schefen.forumserver.entities.Content;
import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.entities.dtos.ContentDto;
import com.schefen.forumserver.entities.dtos.UserDto;
import com.schefen.forumserver.entities.jwt.User;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import com.schefen.forumserver.entities.requests.comment.CommentUpdateRequest;
import com.schefen.forumserver.repositories.CommentRepository;
import com.schefen.forumserver.repositories.ContentRepository;
import com.schefen.forumserver.repositories.JWT.UserRepository;
import com.schefen.forumserver.services.content.ContentService;
import com.schefen.forumserver.services.jwt.AuthService;
import com.schefen.forumserver.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ContentService contentService;

    @Override
    public List<CommentDto> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getCommentByContainsX(String x) {
        List<Comment> filteredComments = commentRepository.getCommentByContainsX(x);
        List<CommentDto> shownComments = filteredComments.stream().map(comment ->
                modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());

        return shownComments;
    }

    @Override
    public CommentDto addComment(CommentCreateRequest createRequest) throws Exception {
        UserDto userDto = userService.findByUsername(createRequest.getAuthorUsername());
        User user = modelMapper.map(userDto,User.class);
        ContentDto contentDto = contentService.findByContentName(createRequest.getContentName());
        Content content = modelMapper.map(contentDto,Content.class);

        if (user!= null && content!= null){
            Comment comment = new Comment();
            comment.setCommentItself(createRequest.getCommentItself());
            comment.setUser(user);
            comment.setContent(content);
            comment.setCreatedDate(LocalDate.now());
            commentRepository.save(comment);
            return modelMapper.map(comment,CommentDto.class);
        }
        else throw new Exception("Hata");

//        Optional<User> user = userRepository.findByUsername(createRequest.getAuthorUsername());
//        Optional<Content> content = contentRepository.findByContentName(createRequest.getContentName());
//
//        Comment comment = new Comment();
//        comment.setCommentItself(createRequest.getCommentItself());
//        comment.setUser(modelMapper.map(user,User.class));
//        comment.setContent(modelMapper.map(content,Content.class));
//        comment.setCreatedDate(LocalDate.now());
//        commentRepository.save(comment);
//        return modelMapper.map(comment,CommentDto.class);
    }
    @Override
    public void editComment(CommentUpdateRequest updateRequest) throws Exception {
        Optional<Comment> comment = commentRepository.findById(updateRequest.getCommentId());
        if (comment.isPresent()){
            Comment existingComment = comment.get();
            existingComment.setCommentItself(updateRequest.getCommentItself());
            commentRepository.save(existingComment);
        }
        else throw new Exception("Kayıt güncellenirken hata.");
    }
    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
