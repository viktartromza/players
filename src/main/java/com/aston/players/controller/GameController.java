package com.aston.players.controller;

import com.aston.players.domain.Game;
import com.aston.players.domain.User;
import com.aston.players.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<Set<Game>> allGames() {
        Set<Game> games  = gameService.allGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
