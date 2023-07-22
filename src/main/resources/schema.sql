DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id                INT AUTO_INCREMENT PRIMARY KEY ,
    login             VARCHAR(255) NOT NULL,
    score             FLOAT8
);