package Test;

import Game.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testes the Fleet class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.2
 */
public class FleetTest {

    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Fleet fleet1;
    private Fleet fleet2;
    private Fleet fleet3;
    private Fleet fleet4;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp(){
        this.player1 = new Player("Player1", 30000);
        this.player2 = new Player("Player2", 30000);
        this.gameBoard = new GameBoard(21);
        this.fleet1 = (Fleet) gameBoard.getField(3);
        this.fleet2 = (Fleet) gameBoard.getField(9);
        this.fleet3 = (Fleet) gameBoard.getField(15);
        this.fleet4 = (Fleet) gameBoard.getField(20);


    }

    @Test
    public void testEntities(){
        assertNotNull(player1);
        assertNotNull(player2);

        assertNotNull(fleet1);
        assertNotNull(fleet2);
        assertNotNull(fleet3);
        assertNotNull(fleet4);

        assertTrue(player1 instanceof Player);
        assertTrue(player2 instanceof Player);

        assertTrue(gameBoard instanceof GameBoard);

        assertTrue(fleet1 instanceof Fleet);
        assertTrue(fleet2 instanceof Fleet);
        assertTrue(fleet3 instanceof Fleet);
        assertTrue(fleet4 instanceof Fleet);
    }

    @Test
    public void getName() throws Exception {

        String expected = "Second Sail";
        String actual = fleet1.getName();
        assertEquals(expected, actual);

        expected = "Sea Grover";
        actual = fleet2.getName();
        assertEquals(expected, actual);

        expected = "Private armade";
        actual = fleet3.getName();
        assertEquals(expected, actual);

        expected = "The Buccaneers";
        actual = fleet4.getName();
        assertEquals(expected, actual);

        fleet1.setName("Change Name");
        expected = "Change Name";
        actual = fleet1.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void getOwner() throws Exception {

        assertTrue(fleet1.getOwner() == null);
        assertTrue(fleet2.getOwner() == null);
        assertTrue(fleet3.getOwner() == null);
        assertTrue(fleet4.getOwner() == null);

        fleet1.setOwner(player1);
        fleet2.setOwner(player1);
        fleet3.setOwner(player1);
        fleet4.setOwner(player1);

        Player expected = player1;
        Player actual = fleet1.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet2.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet3.getOwner();
        assertEquals(expected, actual);

        expected = player1;
        actual = fleet4.getOwner();
        assertEquals(expected, actual);
    }


    @Test
    public void landOnField() throws Exception {

        /**
         * ownership of 1 fleet
         */
        // testes that tha start balance i correct.
        int expected = 30000;
        int actual = this.player1.getAccount().getBalance();
        assertEquals(expected, actual);

        //player1 buys fleet 1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.fleet1.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 26000;
        actual = this.player1.getAccount().getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        Player expectedOwner = player1;
        Player actualOwner = fleet1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 29500;
        actual = player2.getAccount().getBalance();
        assertEquals(expected,actual);

        expected = 26500;
        actual = player1.getAccount().getBalance();
        assertEquals(expected,actual);


        /**
         * owner ship of 2 fleets
         */
        //player1 buys fleet 1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.fleet2.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 22500;
        actual = this.player1.getAccount().getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        expectedOwner = player1;
        actualOwner = fleet1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 28500;
        actual = player2.getAccount().getBalance();
        assertEquals(expected,actual);

        expected = 23500;
        actual = player1.getAccount().getBalance();
        assertEquals(expected,actual);

        /**
         * owner ship of 3 fleets
         */
        //player1 buys fleet 1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.fleet3.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 19500;
        actual = this.player1.getAccount().getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        expectedOwner = player1;
        actualOwner = fleet1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 26500;
        actual = player2.getAccount().getBalance();
        assertEquals(expected,actual);

        expected = 21500;
        actual = player1.getAccount().getBalance();
        assertEquals(expected,actual);

        /**
         * owner ship of 4 fleets
         */
        //player1 buys fleet 1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        this.fleet2.landOnField(this.player1);

        //tests that the price of the field have been trancfered.
        expected = 17500;
        actual = this.player1.getAccount().getBalance();
        assertEquals(expected, actual);

        //tests that the ownership has been terancfered
        expectedOwner = player1;
        actualOwner = fleet1.getOwner();
        assertEquals(expectedOwner, actualOwner);

        this.fleet1.landOnField(player2);
        expected = 22500;
        actual = player2.getAccount().getBalance();
        assertEquals(expected,actual);

        expected = 21500;
        actual = player1.getAccount().getBalance();
        assertEquals(expected,actual);
    }
}