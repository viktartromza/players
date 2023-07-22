package com.aston.players.mapper;

import com.aston.players.domain.User;
import com.aston.players.domain.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse fromUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setLogin(user.getLogin());
        return userResponse;
    }
}
