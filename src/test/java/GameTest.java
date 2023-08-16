import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.services.Game;
import ru.netology.services.NotRegisteredException;
import ru.netology.services.Player;

public class GameTest {

    Game manager = new Game();
    Player player1 = new Player(1, "Сергей", 100);
    Player player2 = new Player(2, "Евгений", 150);
    Player player3 = new Player(3, "Дмитрий", 120);
    Player player4 = new Player(4, "Николай", 120);

    @Test
    public void testRegister() {

        manager.register(player1);
        manager.register(player2);


        int expected = 2;
        int actual = manager.registeredPlayers.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundPlayer2Wins() {
        manager.register(player1);
        manager.register(player2);

        int expected = 2;
        int actual = manager.round("Сергей", "Евгений");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundPlayer1Lose() {
        manager.register(player1);
        manager.register(player2);

        int expected = 1;
        int actual = manager.round("Евгений", "Сергей");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundDraw() {
        manager.register(player3);
        manager.register(player4);

        int expected = 0;
        int actual = manager.round("Дмитрий", "Николай");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundPlayer1NotRegistered() {
        manager.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> manager.round("Евгений", "Сергей"));
    }

    @Test
    public void testRoundPlayer2NotRegistered() {
        manager.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> manager.round("Евгений", "Сергей"));
    }

    @Test
    public void testRoundBothPlayersNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> manager.round("Евгений", "Сергей"));
    }
    @Test
    public void testGetId() {
        manager.register(player1);

        int expected = 1;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

}
