package Test;

import Game.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the flow of the game and if the requirements have been fulfilled
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.1
 */
public class AcceptanceTest {
    Player player1 = new Player("Ole", 10000);
    Player player2 = new Player("Hans", 10000);

    @Before
    public void setUp() throws Exception {

        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");

    }

    @Test
    public void test() throws Exception {

        testMovePlayer(player1, 11);
        testBuyfield(player1);

    }

    private void testBuyfield(Player player) {
        int initialPlayerBalance = player.getAccount().getBalance();
        Ownable currentField = (Ownable) GameController.getGameBoard().getField(player.getOnField());

        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));

        currentField.landOnField(player);

        assertEquals((initialPlayerBalance - currentField.getPrice()), player.getAccount().getBalance());

        assertEquals(player, currentField.getOwner());
    }

    private void testMovePlayer(Player player, int i) {
        GameController.movePlayer(player1, i);
        assertEquals(i, player1.getOnField());
    }

}
