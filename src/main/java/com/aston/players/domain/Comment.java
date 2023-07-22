package com.aston.players.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

}
