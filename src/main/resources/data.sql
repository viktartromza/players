INSERT INTO users (id, login, score)
VALUES (1, 'Tom', 0.00);
INSERT INTO users (id, login, score)
VALUES (2, 'Jerry', 50.00);

INSERT INTO wallets (user_id, balance)
VALUES (1, 0.00);
INSERT INTO wallets (user_id, balance)
VALUES (2, 500.00);

INSERT INTO games (id, game_type)
VALUES (1, 'catch-up');
INSERT INTO games (id, game_type)
VALUES (2, 'fight');

INSERT INTO user_game (user_id, game_id)
VALUES (1, 1);
INSERT INTO user_game (user_id, game_id)
VALUES (2, 1);
INSERT INTO user_game (user_id, game_id)
VALUES (1, 2);
INSERT INTO user_game (user_id, game_id)
VALUES (2, 2);

INSERT INTO comments (id, user_login, comment_text, game_id)
VALUES (1, 'Tom', 'Wow!!!', 1);
INSERT INTO comments (id, user_login, comment_text, game_id)
VALUES (2, 'Jerry', 'No-no!!!', 1);
INSERT INTO comments (id, user_login, comment_text, game_id)
VALUES (3, 'Tom', 'We will rock you!', 2);
INSERT INTO comments (id, user_login, comment_text, game_id)
VALUES (4, 'Jerry', 'Common!', 2);