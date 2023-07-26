package com.aston.players.mapper;

import com.aston.players.model.domain.Comment;
import com.aston.players.model.dto.request.CommentRequest;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment fromRequestToComment(CommentRequest request){
        Comment comment = new Comment();
        comment.setUserLogin(request.getUserLogin());
        comment.setGameId(request.getGameId());
        comment.setText(request.getText());
        return comment;
    }
}
