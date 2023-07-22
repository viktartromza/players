package com.aston.players.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "games")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "games", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
