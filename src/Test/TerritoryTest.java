package Test;

import Game.Player;
import Game.Territory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the territory class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.1
 */

public class TerritoryTest {

    /**
     * Creates the two object needed to test the Territory class
     */
    Territory territory = new Territory(5, "TestTerri", 1000, 100);
    Player player = new Player("John Doe", 10000);

    @Test
    public void getRent() throws Exception {

        assertEquals(100, territory.getRent());
    }

    /**
     * First it is tested that no one owns the field. Then the owner is set and tested.
     *
     * @throws Exception
     */
    @Test
    public void getOwner() throws Exception {

        assertEquals(null, territory.getOwner());

        territory.setOwner(player);

        assertEquals(player, territory.getOwner());

    }

    /**
     * The landOnField method can not be tested automatically as it contains calls to the GUI
     *
     * @throws Exception
     */
    @Test
    public void landOnField() throws Exception {

    }


    @Test
    public void getName() throws Exception {

        assertEquals("TestTerri", territory.getName());

        territory.setName("Ritz"); // TODO: 22-11-2016 BUG?

        assertEquals("RitZ", territory.getName());
    }

}