package Test;

import Game.Refuge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testes the Refuge class
 *
 * Bugs: none known
 *
 * @author       Mathias Larsen
 * @version      v.0.1
 */
public class RefugeTest {

    /**
     * Creates the object needed to test the Refuge class
     */
    Refuge refuge = new Refuge(5, "BaseCamp", 1000);


    /**
     * The landOnField method can not be tested automatically as it contains calls to the GUI
     * @throws Exception
     */
    @Test
    public void landOnField() throws Exception {

    }

    @Test
    public void getName() throws Exception {

        assertEquals("BaseCamp", refuge.getName());

        refuge.setName("Camp42");

        assertEquals("Camp42", refuge.getName());
    }

    /**
     * tests if the field can be converted to the type of field the GUI uses.
     * @throws Exception
     */
    @Test
    public void toGUIField() throws Exception {

        boolean test = false;


        if(refuge.toGUIField() instanceof desktop_fields.Field){
            test = true;
        }
        assertEquals(test, true);
    }

}