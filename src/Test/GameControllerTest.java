package Test;

import Game.GameController;
import Game.InterfaceController;
import Game.Language;
import Game.Player;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the important methods in the GameController
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class GameControllerTest {

    Player player1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void before(){
        GameController.reset();
        player1 = new Player("test player", 1000);
    }

    @Test
    public void getGameBoard() throws Exception {
    assertNotNull(GameController.getGameBoard());
    }

    @Test
    public void getShaker() throws Exception {
        assertNotNull(GameController.getShaker());


    }

    @Test
    public void movePlayer() throws Exception {
        player1.setOnField(0);
        GameController.movePlayer(player1,10);
        assertEquals(player1.getOnField(),10);

        GameController.movePlayer(player1,10);
        assertEquals(player1.getOnField(),20);

        GameController.movePlayer(player1,10);
        assertEquals(player1.getOnField(),9);

    }

}