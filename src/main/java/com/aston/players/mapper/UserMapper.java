package com.aston.players.mapper;

import com.aston.players.model.domain.User;
import com.aston.players.model.dto.request.UserRegistrationRequest;
import com.aston.players.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class UserMapper {
    public User fromRequestUserRegistrationToUser(UserRegistrationRequest registrationRequest) {
        User user = new User();
        user.setLogin(registrationRequest.getLogin());
        user.setScore(0.00);
        return user;
    }

    public UserResponse fromUserToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setLogin(user.getLogin());
        userResponse.setScore(user.getScore());
        userResponse.setWalletBalance(user.getWallet().getBalance());
        Map<Integer, String> games = new HashMap<>();
        user.getGames().forEach(game -> games.put(game.getId(), game.getGameType()));
        userResponse.setGamesInfo(games);
        return userResponse;
    }
}
