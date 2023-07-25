package com.aston.players.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse {
    private Integer id;
    private String gameType;
    private Set<String> userLogin = new HashSet<>();
    private List<String> comments = new ArrayList<>();
}
