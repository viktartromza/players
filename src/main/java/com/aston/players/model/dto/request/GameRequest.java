package com.aston.players.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {
    private String gameType;
    private Set<Integer> usersId;
}
