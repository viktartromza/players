package com.aston.players.service;

import com.aston.players.domain.User;
import com.aston.players.domain.UserResponse;
import com.aston.players.mapper.UserMapper;
import com.aston.players.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse getUserById(int id) {
        return userMapper.fromUserToUserResponse(userRepository.getUserByID(id));
    }
}
