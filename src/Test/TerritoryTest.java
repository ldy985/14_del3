package Test;

import Game.Player;
import Game.Territory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the territory class
 *
 * Bugs: none known
 *
 * @author       Mathias Larsen
 * @version      v.0.1
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
     * @throws Exception
     */
    @Test
    public void landOnField() throws Exception {

    }

    @Test
    public void getName() throws Exception {

        assertEquals("TestTerri", territory.getName());
    }

    /**
     * Tests if the field can be used to create the type of field the GUI uses.
     * @throws Exception
     */
    @Test
    public void toGUIField() throws Exception {

        boolean test = false;


        if(territory.toGUIField() instanceof desktop_fields.Field){
            test = true;
        }
        assertEquals(test, true);
    }

}