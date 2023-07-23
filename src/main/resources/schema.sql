DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    score FLOAT8
);

DROP TABLE IF EXISTS wallets;

CREATE TABLE wallets
(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    balance FLOAT8
);

DROP TABLE IF EXISTS games;

CREATE TABLE games
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    game_type VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS user_game;

CREATE TABLE user_game
(
    user_id INT NOT NULL,
    game_id INT NOT NULL
);

DROP TABLE IF EXISTS comments;

CREATE TABLE comments
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    user_login   VARCHAR(255) NOT NULL,
    comment_text VARCHAR(255) NOT NULL,
    game_id      INT          NOT NULL
);
