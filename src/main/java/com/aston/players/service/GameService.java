package com.aston.players.service;

import com.aston.players.domain.Game;
import com.aston.players.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Set<Game> allGames(){
        return new HashSet<>(gameRepository.findAll());
    }

}
