package Test;

import Game.LaborCamp;
import Game.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the LaborCamp class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.1
 */
public class LaborCampTest {

    LaborCamp labor = new LaborCamp(3, "Gulag", 5000, 300);
    Player player = new Player("John Doe", 20000);

    /**
     * getRent() can not be tested because the GameController can not be tested automatically
     *
     * @throws Exception
     */
    @Test
    public void getRent() throws Exception {

    }

    /**
     * First it is tested that no one owns the field. Then the owner is set and tested.
     *
     * @throws Exception
     */
    @Test
    public void getOwner() throws Exception {

        assertEquals(null, labor.getOwner());

        labor.setOwner(player);

        assertEquals(player, labor.getOwner());

    }

    @Test
    public void getName() throws Exception {

        assertEquals("Gulag", labor.getName());

        labor.setName("Gulag");

        assertEquals("Gulag", labor.getName());
    }

    /**
     * The landOnField method can not be tested automatically as it contains calls to the GUI
     *
     * @throws Exception
     */
    @Test
    public void landOnField() throws Exception {

    }


}