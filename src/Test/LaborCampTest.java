package Test;

import Game.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the LaborCamp class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.3
 */
public class LaborCampTest {

    private Player player1;
    private Player player2;

    private GameBoard gameBoard;

    private Shaker shaker;

    private LaborCamp labor1;
    private LaborCamp labor2;

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

        this.shaker = GameController.getShaker();
        this.labor1 = (LaborCamp) gameBoard.getField(10);
        this.labor2 = (LaborCamp) gameBoard.getField(14);
    }


    @Test
    public void testEntities() {
        assertNotNull(this.player1);
        assertNotNull(this.player2);

        assertNotNull(this.gameBoard);
        assertNotNull(this.labor1);
        assertNotNull(this.labor2);

        assertTrue(this.player1 instanceof Player);
        assertTrue(this.player2 instanceof Player);

        assertTrue(this.gameBoard instanceof GameBoard);
        assertTrue(this.labor1 instanceof LaborCamp);
        assertTrue(this.labor2 instanceof LaborCamp);

    }

    @Test
    public void getRent() throws Exception {
        //tests the baseRent
        int expected = 100;
        int actual = labor1.getBaseRent();
        assertEquals(expected, actual);

        actual = labor2.getBaseRent();
        assertEquals(expected, actual);

        //tests the rent with 3 diffrent values
        shaker.setSum(2);
        expected = 200;
        actual = labor1.getRent();
        assertEquals(expected, actual);

        shaker.setSum(7);
        expected = 700;
        actual = labor1.getRent();
        assertEquals(expected, actual);

        shaker.setSum(12);
        expected = 1200;
        actual = labor1.getRent();
        assertEquals(expected, actual);


        shaker.setSum(2);
        expected = 200;
        actual = labor2.getRent();
        assertEquals(expected, actual);

        shaker.setSum(7);
        expected = 700;
        actual = labor2.getRent();
        assertEquals(expected, actual);

        shaker.setSum(12);
        expected = 1200;
        actual = labor2.getRent();
        assertEquals(expected, actual);

    }

    /**
     * First it is tested that no one owns the field. Then the owner is set and tested.
     *
     * @throws Exception
     */
    @Test
    public void getOwner() throws Exception {

        assertTrue(labor1.getOwner() == null);
        assertTrue(labor2.getOwner() == null);

        labor1.setOwner(player1);
        labor2.setOwner(player1);

        Player expected = player1;
        Player actual = labor1.getOwner();
        assertEquals(expected, actual);

        actual = labor2.getOwner();
        assertEquals(expected, actual);
    }

    @Test
    public void getName() throws Exception {

        //tests the name of the fields
        String expected = "Huts in the mountain";
        String actual = labor1.getName();
        assertEquals(expected, actual);

        expected = "The pit";
        actual = labor2.getName();
        assertEquals(expected, actual);

        //changes the name
        labor1.setName("Change");

        //tests that the name has been changed
        expected = "Change";
        actual = labor1.getName();
        assertEquals(expected, actual);
    }


    @Test
    public void landOnField() throws Exception {

        //tests that the players starts with the correct ballance
        int expected = 30000;
        int actual = player1.getBalance();
        assertEquals(expected, actual);

        actual = player2.getBalance();
        assertEquals(expected, actual);


        //player1 buys labor1
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        labor1.landOnField(player1);

        //tests that ownership have been transfered
        Player expectedPlayer = player1;
        Player actualPlayer = labor1.getOwner();
        assertEquals(expectedPlayer, actualPlayer);


        //tests that the money have been transfered
        expected = 27500;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        //player1 buys labor2
        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
        labor2.landOnField(player1);

        //tests that ownership have been tranfered
        actualPlayer = labor2.getOwner();
        assertEquals(expectedPlayer, actualPlayer);

        //tests if the mpony have been tarnsfered
        expected = 25000;
        actual = player1.getBalance();
        assertEquals(expected, actual);


        //tests if the rent works for labor 1
        shaker.setSum(2);
        labor1.landOnField(player2);

        expected = 29800;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 25200;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        shaker.setSum(5);
        labor1.landOnField(player2);

        expected = 29300;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 25700;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        shaker.setSum(12);
        labor1.landOnField(player2);

        expected = 28100;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 26900;
        actual = player1.getBalance();
        assertEquals(expected, actual);


        //tests if the rent works for labor 2
        shaker.setSum(2);
        labor1.landOnField(player2);

        expected = 27900;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 27100;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        shaker.setSum(5);
        labor1.landOnField(player2);

        expected = 27400;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 27600;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        shaker.setSum(12);
        labor1.landOnField(player2);

        expected = 26200;
        actual = player2.getBalance();
        assertEquals(expected, actual);

        //tests that the money have been transfered to player 1
        expected = 28800;
        actual = player1.getBalance();
        assertEquals(expected, actual);


        //tests that no rent is charged if the player who lands on the field also owns it
        labor1.landOnField(player1);
        expected = 28800;
        actual = player1.getBalance();
        assertEquals(expected, actual);

        labor2.landOnField(player1);
        actual = player1.getBalance();
        assertEquals(expected, actual);

    }


}