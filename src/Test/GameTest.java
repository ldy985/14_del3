package Test;

import Game.GameController;
import org.junit.Test;

import static Game.Language.setLanguage;
import static org.junit.Assert.assertEquals;

/**
 * Created by razze on 17-11-2016.
 */
public class GameTest {

    @Test
    public void benchmark(){

        double timestart = System.nanoTime();

        // Selects the language
        setLanguage("english");
        GameController gameController = new GameController();

        double timeEnded = System.nanoTime();

        double timeTaken = (timeEnded - timestart)/ 1000000.0;//ms

        System.out.println(timeTaken);

        assertEquals(true, timeTaken < 1100);



    }


}
