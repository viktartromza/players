package com.aston.players.repository;

import com.aston.players.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "user_entity-graph")
    List<User> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "user_entity-graph")
    Optional<User> findById(int id);
}

