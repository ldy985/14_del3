package Test;

import Game.GameController;
import org.junit.Test;

import static Game.Language.setLanguage;
import static org.junit.Assert.assertEquals;


/**
 * Tests the Game class
 *
 * Bugs: none known
 *
 * @author       Rasmus Blichfeldt
 * @version      v.0.1
 */

public class GameTest {

    @Test
    public void benchmark(){

        double timestart = System.nanoTime();

        // Selects the language
        setLanguage("english");
        GameController gameController = new GameController(); // TODO: 21-11-2016 FIX gamecontroller creation

        double timeEnded = System.nanoTime();

        double timeTaken = (timeEnded - timestart)/ 1000000.0;//ms

        System.out.println(timeTaken);

        assertEquals(true, timeTaken < 1100);



    }


}
