package com.aston.players.model.dto.response;

import com.aston.players.model.domain.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String login;
    private double score;
    private double walletBalance;
    private Map<Integer, String> gamesInfo = new HashMap<>();
}
