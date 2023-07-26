package com.aston.players.controllerTests;

import com.aston.players.controller.UserController;
import com.aston.players.model.dto.request.UserRegistrationRequest;
import com.aston.players.model.dto.response.UserResponse;
import com.aston.players.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;
    private final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    @Test
    public void getAllUsersTest() throws Exception {
        when(userService.getAllUsers()).thenReturn(new HashSet<>());
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andReturn();
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void userInfoById() throws Exception {
        int id = 1;
        when(userService.getUserById(id)).thenReturn(new UserResponse());
        mockMvc.perform(get("/users/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andReturn();
        verify(userService, times(1)).getUserById(id);
    }

    @Test
    public void createUserTest() throws Exception {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest("Tom");
        when(userService.createUser(userRegistrationRequest)).thenReturn(new UserResponse());
        mockMvc.perform(post("/users/registration")
                        .contentType(APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(userRegistrationRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andReturn();
        verify(userService, times(1)).createUser(userRegistrationRequest);
    }
}
