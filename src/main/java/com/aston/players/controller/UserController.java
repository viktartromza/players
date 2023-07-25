package com.aston.players.controller;

import com.aston.players.model.domain.User;
import com.aston.players.model.dto.request.UserRegistrationRequest;
import com.aston.players.model.dto.response.UserResponse;
import com.aston.players.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRegistrationRequest registrationRequest) {
        return new ResponseEntity<>(userService.createUser(registrationRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<UserResponse>> allUsers() {
        Set<UserResponse> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> userInfo(@PathVariable int id) {
        UserResponse userResponse = userService.getUserById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}