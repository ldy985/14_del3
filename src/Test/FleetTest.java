package Test;

import Game.Fleet;
import Game.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the Fleet class
 *
 * Bugs: none known
 *
 * @author       Mathias Larsen
 * @version      v.0.1
 */
public class FleetTest {

    /**
     * Creates the two object needed to test the Territory class
     */
    Fleet fleet = new Fleet(5, "DFDS", 1000);
    Player player = new Player("John Doe", 10000);

    /**
     * can not be tested automatically because the GameController is needed.
     * @throws Exception
     */
    @Test
    public void getRent() throws Exception {

    }

    @Test
    public void getOwner() throws Exception {

        assertEquals(null, fleet.getOwner());

        fleet.setOwner(player);

        assertEquals(player, fleet.getOwner());
    }

    

    @Test
    public void getName() throws Exception {

        assertEquals("DFDS", fleet.getName());

        fleet.setName("Hej Kaj");

        assertEquals("Hej Kaj", fleet.getName());
    }

    /**
     * The landOnField method can not be tested automatically as it contains calls to the GUI
     * @throws Exception
     */
    @Test
    public void landOnField() throws Exception {

    }


}