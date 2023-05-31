package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or more players are not registered.");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1; // Player 1 wins
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2; // Player 2 wins
        } else {
            return 0; // Draw
        }
    }

}
