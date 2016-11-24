package Test;

import Game.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testes the territory class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.1
 */

public class TerritoryTest {

    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Territory territory1;
    private Territory territory2;
    private Territory territory3;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp() {
        this.player1 = new Player("Player1", 30000);
        this.player2 = new Player("Player2", 30000);
        this.gameBoard = new GameBoard(21);
        this.territory1 = (Territory) gameBoard.getField(1);
        this.territory2 = (Territory) gameBoard.getField(2);
        this.territory3 = (Territory) gameBoard.getField(5);
    }

    @Test
    public void testEntities(){
        assertNotNull(this.player1);
        assertNotNull(this.player2);

        assertNotNull(this.gameBoard);

        assertNotNull(this.territory1);
        assertNotNull(this.territory2);
        assertNotNull(this.territory3);

        assertTrue(this.player1 instanceof Player);
        assertTrue(this.player2 instanceof Player);

        assertTrue(this.gameBoard instanceof GameBoard);

        assertTrue(this.territory1 instanceof  Territory);
        assertTrue(this.territory2 instanceof  Territory);
        assertTrue(this.territory3 instanceof  Territory);

    }

    @Test
    public void getRent() throws Exception {

        int expected = 100;
        int actual = territory1.getRent();
        assertEquals(expected,actual);

        expected = 300;
        actual = territory2.getRent();
        assertEquals(expected,actual);

        expected = 500;
        actual = territory3.getRent();
        assertEquals(expected,actual);
    }


    @Test
    public void getOwner() throws Exception {

        assertTrue(territory1.getOwner() == null);
        assertTrue(territory2.getOwner() == null);
        assertTrue(territory3.getOwner() == null);

        territory1.setOwner(player1);
        territory2.setOwner(player1);
        territory3.setOwner(player1);

        Player expectd = player1;
        Player actual = territory1.getOwner();
        assertEquals(expectd,actual);

        expectd = player1;
        actual = territory2.getOwner();
        assertEquals(expectd,actual);

        expectd = player1;
        actual = territory3.getOwner();
        assertEquals(expectd,actual);
    }

    @Test
    public void getName() throws Exception {

        String expected = "Tribe Encampment";
        String actual = territory1.getName();
        assertEquals(expected,actual);

        expected = "Crater";
        actual = territory2.getName();
        assertEquals(expected,actual);

        expected = "Mountain";
        actual = territory3.getName();
        assertEquals(expected,actual);

    }


    @Test
    public void landOnField() throws Exception {

        // testes that tha start balance i correct.
        int expected = 30000;
        int actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //player1 buys territory 1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.territory1.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 29000;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        Player expectedOwner = player1;
        Player actualOwner = territory1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        //test that player2 payes rent
        this.territory1.landOnField(player2);
        expected = 29900;
        actual = player2.getBalance();
        assertEquals(expected,actual);

        //test that player1 recives the rent
        expected = 29100;
        actual = player1.getBalance();
        assertEquals(expected,actual);




        //player1 buys territory 2
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.territory2.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 27600;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        expectedOwner = player1;
        actualOwner = territory2.getOwner();
        assertEquals(expectedOwner, actualOwner);

        //test that player2 payes rent
        this.territory2.landOnField(player2);
        expected = 29600;
        actual = player2.getBalance();
        assertEquals(expected,actual);

        //test that player1 recives the rent
        expected = 27900;
        actual = player1.getBalance();
        assertEquals(expected,actual);



        //player1 buys territory 3
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.territory3.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 25900;
        actual = this.player1.getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        expectedOwner = player1;
        actualOwner = territory3.getOwner();
        assertEquals(expectedOwner, actualOwner);

        //test that player2 payes rent
        this.territory3.landOnField(player2);
        expected = 29100;
        actual = player2.getBalance();
        assertEquals(expected,actual);

        //test that player1 recives the rent
        expected = 26400;
        actual = player1.getBalance();
        assertEquals(expected,actual);


    }
}