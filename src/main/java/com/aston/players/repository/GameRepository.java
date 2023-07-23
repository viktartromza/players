package com.aston.players.repository;

import com.aston.players.domain.Game;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "comments")
    List<Game> findAll();
}
