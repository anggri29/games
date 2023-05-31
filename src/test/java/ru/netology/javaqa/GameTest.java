package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void testRound1() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 5);
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Player 1", "Player 2"));
    }

    @Test
    void testRound2() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 5);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Player 1", "Player 2"));
    }

    @Test
    void testRoundDraw() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Player 1", "Player 2"));

    }

    @Test
    void Player1NotRegistered() {
        Game game = new Game();
        Player player2 = new Player(2, "Player 2", 5);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player 1", "Player 2"));
    }

    @Test
    void Player2NotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 5);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player 1", "Player 2"));
    }

    @Test
    void BothNotRegistered() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Player 1", "Player 2"));
    }


}
