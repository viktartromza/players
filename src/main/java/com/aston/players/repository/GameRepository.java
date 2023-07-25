package com.aston.players.repository;

import com.aston.players.model.domain.Game;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game,Integer> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "game_entity-graph")
    List<Game> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "game_entity-graph")
    Optional<Game> findById(int id);
}
