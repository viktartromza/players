package com.aston.players.service;

import com.aston.players.domain.User;
import com.aston.players.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.getUserByID(id);
    }

    public Set<User> getAllUsers() {
        return new HashSet<>(userRepository.getAllUsers());
    }
}
