package com.aston.players.mapper;

import com.aston.players.model.domain.Game;
import com.aston.players.model.dto.request.GameRequest;
import com.aston.players.model.dto.response.GameResponse;
import com.aston.players.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class GameMapper {

    private final UserRepository userRepository;

    @Autowired
    public GameMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Game fromRequestToGame(GameRequest request) {
        Game game = new Game();
        game.setGameType(request.getGameType());
        game.setUsers(new HashSet<>(userRepository.findAll()));
        return game;
    }

    public GameResponse fromGameToResponse(Game game) {
        GameResponse response = new GameResponse();
        response.setId(game.getId());
        response.setGameType(game.getGameType());
        response.setUserLogin(game.getUsers().stream().map(user -> user.getLogin()).collect(Collectors.toSet()));
        response.setComments(game.getComments().stream().map(comment -> new String(comment.getUserLogin() + ": " + comment.getText())).collect(Collectors.toList()));
        return response;
    }
}
