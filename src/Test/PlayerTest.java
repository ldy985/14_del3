package Test;

import Game.Player;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the Player class
 *
 * Bugs: none known
 *
 * @author       Mathias Larsen
 * @version      v.0.1
 */
public class PlayerTest {

    /**
     * creates a player object.
     */
    Player player = new Player("Player1", 10000);

    /**
     * tests the realEstateValue. this value is the value of the fields owned by the player.
     * @throws Exception
     */
    @Test
    public void getRealEstateValue() throws Exception {

        player.addRealEstateValue(5000);

        assertEquals(5000, player.getRealEstateValue());

        player.addRealEstateValue(1000);

        assertEquals(6000, player.getRealEstateValue());
    }

    /**
     * Tests that an account object has been created.
     * @throws Exception
     */
    @Test
    public void getAccount() throws Exception {

        assertNotNull(player.getAccount());
    }

    @Test
    public void getName() throws Exception {

        assertEquals("Player1", player.getName());
    }

    @Test
    public void getOnField() throws Exception {

        player.setOnField(20);

        assertEquals(20, player.getOnField());
    }
}