package com.aston.players.service;

import com.aston.players.mapper.CommentMapper;
import com.aston.players.model.domain.Comment;
import com.aston.players.model.dto.request.CommentRequest;
import com.aston.players.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper=commentMapper;
    }

    public Comment findCommentById(int id) {
        return commentRepository.findById(id);
    }

    public void createComment (CommentRequest request){
        commentRepository.save(commentMapper.fromRequestToComment(request));
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
