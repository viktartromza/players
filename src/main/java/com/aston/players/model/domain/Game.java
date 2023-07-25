package com.aston.players.model.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "games")
@NamedEntityGraph(name = "game_entity-graph", attributeNodes = {@NamedAttributeNode("users"),
        @NamedAttributeNode("comments")})
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_type")
    private String gameType;

    @ManyToMany
            (cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_game",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    @JsonManagedReference
    private Set<User> users = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private List<Comment> comments = new ArrayList<>();
}
