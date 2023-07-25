package com.aston.players.controller;

import com.aston.players.model.dto.request.GameRequest;
import com.aston.players.model.dto.response.GameResponse;
import com.aston.players.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> createGame(@RequestBody GameRequest request){
        gameService.createGame(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> gameInfo(@PathVariable int id) {
        GameResponse game = gameService.gameInfo(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<GameResponse>> allGames() {
        Set<GameResponse> games = gameService.allGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
