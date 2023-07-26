package com.aston.players.service;

import com.aston.players.mapper.UserMapper;
import com.aston.players.model.domain.User;
import com.aston.players.model.dto.request.UserRegistrationRequest;
import com.aston.players.model.dto.response.UserResponse;
import com.aston.players.repository.UserRepository;
import com.aston.players.repository.UserRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRepositoryHibernate userRepositoryHibernate;
    private final UserMapper userMapper;
    private final WalletService walletService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, WalletService walletService, UserRepositoryHibernate userRepositoryHibernate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.walletService = walletService;
        this.userRepositoryHibernate = userRepositoryHibernate;
    }

    public UserResponse createUser(UserRegistrationRequest registrationRequest) {
        User user = userMapper.fromRequestUserRegistrationToUser(registrationRequest);
        User savedUser = userRepository.saveAndFlush(user);
        savedUser.setWallet(walletService.createWalletForUser(savedUser));
        return userMapper.fromUserToResponse(savedUser);
    }

    public UserResponse getUserById(int id) {
        return userMapper.fromUserToResponse(userRepository.findById(id).get());
    }

    public Set<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(user -> userMapper.fromUserToResponse(user)).collect(Collectors.toSet());
    }

    public Set<UserResponse> getAllUsersLazy() {
        return userRepositoryHibernate.findAll().stream().map(user -> userMapper.fromUserToResponse(user)).collect(Collectors.toSet());
    }


}
