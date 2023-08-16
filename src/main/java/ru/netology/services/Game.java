package ru.netology.services;

import java.util.*;

public class Game {
    public final List<Player> registeredPlayers;
    public final Map<String, Player> playersMap;

    public Game() {
        registeredPlayers = new ArrayList<>();
        playersMap = new HashMap<>();
    }

    public void register(Player player) {
        registeredPlayers.add(player);
        playersMap.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = playersMap.get(playerName1);
        Player player2 = playersMap.get(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Один или оба игрока не зарегистрированы.");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
