package com.schefen.forumserver.services.comment;

import com.schefen.forumserver.entities.Comment;
import com.schefen.forumserver.entities.dtos.CommentDto;
import com.schefen.forumserver.entities.requests.comment.CommentCreateRequest;
import com.schefen.forumserver.entities.requests.comment.CommentUpdateRequest;
import com.schefen.forumserver.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;

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
    public CommentDto addComment(CommentCreateRequest createRequest) {
        Comment comment = modelMapper.map(createRequest, Comment.class);
        commentRepository.save(comment);
        return modelMapper.map(comment,CommentDto.class);
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
