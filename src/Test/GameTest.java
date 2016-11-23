package Test;

import Game.Field;
import Game.GameController;
import Game.InterfaceController;
import org.junit.Test;

import static Game.Language.setLanguage;
import static org.junit.Assert.assertEquals;


/**
 * Tests the Game class
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt
 * @version v.0.1
 */

public class GameTest {

    @Test
    public void benchmark() {

        double timestart = System.nanoTime();

        // Selects the language
        setLanguage("english");
        InterfaceController.setInterfaceMode(InterfaceController.Mode.GUI);



        Field[] board = GameController.getGameBoard().loadBoardFromFile("board.cfg");
        InterfaceController.showOnGui(board);

        InterfaceController.close();

        double timeEnded = System.nanoTime();

        double timeTaken = (timeEnded - timestart) / 1000000.0;//ms

        System.out.println(timeTaken);

        assertEquals(true, timeTaken < 2500);


    }


}
