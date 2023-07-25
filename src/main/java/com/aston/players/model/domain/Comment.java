package com.aston.players.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "comments")
@NoArgsConstructor
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "comment_text")
    private String text;
}
