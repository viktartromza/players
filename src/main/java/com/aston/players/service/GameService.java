package com.aston.players.service;

import com.aston.players.mapper.GameMapper;
import com.aston.players.model.domain.Game;
import com.aston.players.model.dto.request.GameRequest;
import com.aston.players.model.dto.response.GameResponse;
import com.aston.players.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Autowired
    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public void createGame(GameRequest request){
        Game game=gameMapper.fromRequestToGame(request);
        gameRepository.saveAndFlush(game);
    }

    public GameResponse gameInfo(int id){
        return gameMapper.fromGameToResponse(gameRepository.findById(id).get());
    }

    public Set<GameResponse> allGames() {
        return gameRepository.findAll().stream().map(game -> gameMapper.fromGameToResponse(game)).collect(Collectors.toSet());
    }
}
