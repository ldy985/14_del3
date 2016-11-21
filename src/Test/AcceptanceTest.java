package Test;

import Game.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes the flow of the game and if the requirements have been fulfilled
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.2
 */
public class AcceptanceTest {

//
//
//    private void testBuyfield(Player player) {
//        int initialPlayerBalance = player.getAccount().getBalance();
//        Ownable currentField = (Ownable) GameController.getGameBoard().getField(player.getOnField());
//
//        InterfaceController.setPreDefinedAnswer(Language.getString("yes"));
//
//        currentField.landOnField(player);
//
//        assertEquals((initialPlayerBalance - currentField.getPrice()), player.getAccount().getBalance());
//
//        assertEquals(player, currentField.getOwner());
//    }
//
//    private void testMovePlayer(Player player, int i) {
//        GameController.movePlayer(player1, i);
//        assertEquals(i, player1.getOnField());
//    }

    private GameController gameController; // TODO: 21-11-2016 FIX gamecontroller creation
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;
    //private Shaker shaker;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }


    @Before
    public void setUp() throws Exception {
        this.gameController = new GameController();
        this.gameBoard = new GameBoard(21);
        this.player1 = new Player("player1", 30000);
        this.player2 = new Player("player2", 30000);
        this.player3 = new Player("player3", 30000);
        this.player4 = new Player("player4", 30000);
        this.player5 = new Player("player5", 30000);
        this.player6 = new Player("player6", 30000);


    }

    @After
    public void tearDown() throws Exception {
        //all ententes are reset in the setup phase.

    }

    @Test
    public void testEntities(){
        //testes that the gameboard have been created
        assertNotNull(this.gameBoard);

        //tests that all the fields have been created
        assertNotNull(this.gameBoard.getField(1));
        assertNotNull(this.gameBoard.getField(2));
        assertNotNull(this.gameBoard.getField(3));
        assertNotNull(this.gameBoard.getField(4));
        assertNotNull(this.gameBoard.getField(5));
        assertNotNull(this.gameBoard.getField(6));
        assertNotNull(this.gameBoard.getField(7));
        assertNotNull(this.gameBoard.getField(8));
        assertNotNull(this.gameBoard.getField(9));
        assertNotNull(this.gameBoard.getField(10));
        assertNotNull(this.gameBoard.getField(11));
        assertNotNull(this.gameBoard.getField(12));
        assertNotNull(this.gameBoard.getField(13));
        assertNotNull(this.gameBoard.getField(14));
        assertNotNull(this.gameBoard.getField(15));
        assertNotNull(this.gameBoard.getField(16));
        assertNotNull(this.gameBoard.getField(17));
        assertNotNull(this.gameBoard.getField(18));
        assertNotNull(this.gameBoard.getField(19));
        assertNotNull(this.gameBoard.getField(20));
        assertNotNull(this.gameBoard.getField(21));

        //testes that all the players have been created
        assertNotNull(this.player1);
        assertNotNull(this.player2);
        assertNotNull(this.player3);
        assertNotNull(this.player4);
        assertNotNull(this.player5);
        assertNotNull(this.player6);

        //tests shaker
        assertNotNull(GameController.getShaker());

        //tests gameController
        assertNotNull(this.gameController);

        //tests the type of the ententes
        assertTrue(this.gameBoard instanceof GameBoard);

        assertTrue(this.gameController instanceof GameController);

        assertTrue(this.gameBoard.getField(1) instanceof Territory);
        assertTrue(this.gameBoard.getField(2) instanceof Territory);
        assertTrue(this.gameBoard.getField(3) instanceof Fleet);
        assertTrue(this.gameBoard.getField(4) instanceof Tax);
        assertTrue(this.gameBoard.getField(5) instanceof Territory);
        assertTrue(this.gameBoard.getField(6) instanceof Refuge);
        assertTrue(this.gameBoard.getField(7) instanceof Territory);
        assertTrue(this.gameBoard.getField(8) instanceof Territory);
        assertTrue(this.gameBoard.getField(9) instanceof Fleet);
        assertTrue(this.gameBoard.getField(10) instanceof LaborCamp);
        assertTrue(this.gameBoard.getField(11) instanceof Territory);
        assertTrue(this.gameBoard.getField(12) instanceof Territory);
        assertTrue(this.gameBoard.getField(13) instanceof Territory);
        assertTrue(this.gameBoard.getField(14) instanceof LaborCamp);
        assertTrue(this.gameBoard.getField(15) instanceof Fleet);
        assertTrue(this.gameBoard.getField(16) instanceof Tax);
        assertTrue(this.gameBoard.getField(17) instanceof Territory);
        assertTrue(this.gameBoard.getField(18) instanceof Territory);
        assertTrue(this.gameBoard.getField(19) instanceof Territory);
        assertTrue(this.gameBoard.getField(20) instanceof Fleet);
        assertTrue(this.gameBoard.getField(21) instanceof Refuge);

        assertTrue(this.player1 instanceof Player);
        assertTrue(this.player2 instanceof Player);
        assertTrue(this.player3 instanceof Player);
        assertTrue(this.player4 instanceof Player);
        assertTrue(this.player5 instanceof Player);
        assertTrue(this.player6 instanceof Player);

        assertTrue(GameController.getShaker() instanceof  Shaker);

    }

    @Test
    public void testNames(){

        //of players
        String expected = "player1";
        String actual = player1.getName();
        assertEquals(expected, actual);

        expected = "player2";
        actual = player2.getName();
        assertEquals(expected, actual);

        expected = "player3";
        actual = player3.getName();
        assertEquals(expected, actual);

        expected = "player4";
        actual = player4.getName();
        assertEquals(expected, actual);

        expected = "player5";
        actual = player5.getName();
        assertEquals(expected, actual);

        expected = "player6";
        actual = player6.getName();
        assertEquals(expected, actual);


        //of fields
        expected = "Tribe Encampment";
        actual = gameBoard.getField(1).getName();
        assertEquals(expected, actual);

        expected = "Crater";
        actual = gameBoard.getField(2).getName();
        assertEquals(expected, actual);

        expected = "Second Sail";
        actual = gameBoard.getField(3).getName();
        assertEquals(expected, actual);

        expected = "Goldmine";
        actual = gameBoard.getField(4).getName();
        assertEquals(expected, actual);

        expected = "Mountain";
        actual = gameBoard.getField(5).getName();
        assertEquals(expected, actual);

        expected = "Walled city";
        actual = gameBoard.getField(6).getName();
        assertEquals(expected, actual);

        expected = "Cold Desert";
        actual = gameBoard.getField(7).getName();
        assertEquals(expected, actual);

        expected = "Black cave";
        actual = gameBoard.getField(8).getName();
        assertEquals(expected, actual);

        expected = "Sea Grover";
        actual = gameBoard.getField(9).getName();
        assertEquals(expected, actual);

        expected = "Huts in the mountain";
        actual = gameBoard.getField(10).getName();
        assertEquals(expected, actual);

        expected = "The Werewall";
        actual = gameBoard.getField(11).getName();
        assertEquals(expected, actual);

        expected = "Mountain village";
        actual = gameBoard.getField(12).getName();
        assertEquals(expected, actual);

        expected = "South Citadel";
        actual = gameBoard.getField(13).getName();
        assertEquals(expected, actual);

        expected = "The pit";
        actual = gameBoard.getField(14).getName();
        assertEquals(expected, actual);

        expected = "Private armade";
        actual = gameBoard.getField(15).getName();
        assertEquals(expected, actual);

        expected = "Caravan";
        actual = gameBoard.getField(16).getName();
        assertEquals(expected, actual);

        expected = "Palace gates";
        actual = gameBoard.getField(17).getName();
        assertEquals(expected, actual);

        expected = "Tower";
        actual = gameBoard.getField(18).getName();
        assertEquals(expected, actual);

        expected = "Castle";
        actual = gameBoard.getField(19).getName();
        assertEquals(expected, actual);

        expected = "The Buccaneers";
        actual = gameBoard.getField(20).getName();
        assertEquals(expected, actual);

        expected = "Monastery";
        actual = gameBoard.getField(21).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testRent(){

        Territory currentField = (Territory) gameBoard.getField(1);
        int expected = 100;
        int actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(2);
        expected = 300;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(5);
        expected = 500;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(7);
        expected = 700;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(8);
        expected = 1000;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(11);
        expected = 1300;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(12);
        expected = 1600;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(13);
        expected = 2000;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(17);
        expected = 2600;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(18);
        expected = 3200;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        currentField = (Territory) gameBoard.getField(19);
        expected = 4000;
        actual = currentField.getRent();
        assertEquals(expected, actual);

        LaborCamp currentLabor = (LaborCamp) gameBoard.getField(10);
        GameController.getShaker().setSum(2);
        expected = -2*100;
        actual = currentLabor.getRent();
        assertEquals(expected, actual);

        GameController.getShaker().setSum(5);
        expected = -5*100;
        actual = currentLabor.getRent();
        assertEquals(expected,actual);

        GameController.getShaker().setSum(12);
        expected = -12*100;
        actual = currentLabor.getRent();
        assertEquals(expected,actual);


        currentLabor = (LaborCamp) gameBoard.getField(14);
        GameController.getShaker().setSum(2);
        expected = -2*100;
        actual = currentLabor.getRent();
        assertEquals(expected, actual);

        GameController.getShaker().setSum(5);
        expected = -5*100;
        actual = currentLabor.getRent();
        assertEquals(expected,actual);

        GameController.getShaker().setSum(12);
        expected = -12*100;
        actual = currentLabor.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 1 of 15. a permutation here is the diffrent
     * ways a player can own the 4 fleet fields.
     * the permuatations are found using the formula.
     * n!/(r!*(n-r)!)
     * where n is the number of fleet fields and r is the number of fleets owned.
     */
    @Test
    public void testFleetRent1(){
        Fleet currentFleet = (Fleet) gameBoard.getField(3);
        currentFleet.setOwner(player1);
        int expected = 500;
        int actual = currentFleet.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 2 of 15.
     */
    @Test
    public void testFleetRent2(){
        Fleet currentFleet = (Fleet) gameBoard.getField(9);
        currentFleet.setOwner(player1);
        int expected = 500;
        int actual = currentFleet.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 3 of 15.
     */
    @Test
    public void testFleetRent3(){
        Fleet currentFleet = (Fleet) gameBoard.getField(15);
        currentFleet.setOwner(player1);
        int expected = 500;
        int actual = currentFleet.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 4 of 15.
     */
    @Test
    public void testFleetRent4(){
        Fleet currentFleet = (Fleet) gameBoard.getField(20);
        currentFleet.setOwner(player1);
        int expected = 500;
        int actual = currentFleet.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 5 of 15.
     */
    @Test
    public void testFleetRent5(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(9);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 6 of 15.
     */
    @Test
    public void testFleetRent6(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(15);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 7 of 15.
     */
    @Test
    public void testFleetRent7(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(20);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 8 of 15.
     */
    @Test
    public void testFleetRent8(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(9);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(15);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 9 of 15.
     */
    @Test
    public void testFleetRent9(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(9);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(20);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 10 of 15.
     */
    @Test
    public void testFleetRent10(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(15);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(20);
        currentFleet2.setOwner(player1);
        int expected = 1000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 11 of 15.
     */
    @Test
    public void testFleetRent11(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(9);
        currentFleet2.setOwner(player1);
        Fleet currentFleet3 = (Fleet) gameBoard.getField(15);
        currentFleet3.setOwner(player1);
        int expected = 2000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
        actual = currentFleet3.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 12 of 15.
     */
    @Test
    public void testFleetRent12(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(9);
        currentFleet2.setOwner(player1);
        Fleet currentFleet3 = (Fleet) gameBoard.getField(20);
        currentFleet3.setOwner(player1);
        int expected = 2000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
        actual = currentFleet3.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 13 of 15.
     */
    @Test
    public void testFleetRent13(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(15);
        currentFleet2.setOwner(player1);
        Fleet currentFleet3 = (Fleet) gameBoard.getField(20);
        currentFleet3.setOwner(player1);
        int expected = 2000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
        actual = currentFleet3.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 14 of 15.
     */
    @Test
    public void testFleetRent14(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(9);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(15);
        currentFleet2.setOwner(player1);
        Fleet currentFleet3 = (Fleet) gameBoard.getField(20);
        currentFleet3.setOwner(player1);
        int expected = 2000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
        actual = currentFleet3.getRent();
        assertEquals(expected,actual);
    }

    /**
     * tests permutation 15 of 15.
     */
    @Test
    public void testFleetRent15(){
        Fleet currentFleet1 = (Fleet) gameBoard.getField(3);
        currentFleet1.setOwner(player1);
        Fleet currentFleet2 = (Fleet) gameBoard.getField(9);
        currentFleet2.setOwner(player1);
        Fleet currentFleet3 = (Fleet) gameBoard.getField(15);
        currentFleet3.setOwner(player1);
        Fleet currentFleet4 = (Fleet) gameBoard.getField(20);
        currentFleet4.setOwner(player1);
        int expected = 4000;
        int actual = currentFleet1.getRent();
        assertEquals(expected,actual);
        actual = currentFleet2.getRent();
        assertEquals(expected,actual);
        actual = currentFleet3.getRent();
        assertEquals(expected,actual);
        actual = currentFleet4.getRent();
        assertEquals(expected,actual);
    }

    @Test
    public void testPrice(){
        Ownable field = (Ownable) gameBoard.getField(1);
        int expected = 1000;
        int actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(2);
        expected = 1500;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(3);
        expected = 4000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(5);
        expected = 2000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(7);
        expected = 3000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(8);
        expected = 4000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(9);
        expected = 4000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(10);
        expected = 2500;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(11);
        expected = 4300;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(12);
        expected = 4750;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(13);
        expected = 5000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(14);
        expected = 2500;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(15);
        expected = 4000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(17);
        expected = 5500;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(18);
        expected = 6000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(19);
        expected = 8000;
        actual = field.getPrice();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(20);
        expected = 4000;
        actual = field.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void testOwner(){
        Ownable field = (Ownable) gameBoard.getField(1);
        field.setOwner(player1);
        Player expected = player1;
        Player actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(2);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(3);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(5);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(7);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(8);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(9);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(10);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(11);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(12);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(13);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(14);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(15);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(17);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(18);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(19);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

        field = (Ownable) gameBoard.getField(20);
        field.setOwner(player1);
        expected = player1;
        actual = field.getOwner();
        assertEquals(expected,actual);

    }

    @Test
    public void testBonus(){
        Refuge refuge = (Refuge) gameBoard.getField(6);
        int expected = 5000;
        int actual = refuge.getBonus();
        assertEquals(expected,actual);

        refuge = (Refuge) gameBoard.getField(21);
        expected = 500;
        actual = refuge.getBonus();
        assertEquals(expected,actual);
    }

    @Test
    public void testTaxAmount(){
        Tax tax = (Tax) gameBoard.getField(4);
        int expected = 2000;
        int actual = tax.getTaxAmount();
        assertEquals(expected,actual);

        tax = (Tax) gameBoard.getField(16);
        expected = 4000;
        actual = tax.getTaxAmount();
        assertEquals(expected,actual);
    }

    @Test
    public void testTaxRate(){
        Tax tax = (Tax) gameBoard.getField(4);
        float expected = (float) 1.0;
        float actual = tax.getTaxRate();
        assertEquals(expected,actual, 0.0001);

        tax = (Tax) gameBoard.getField(16);
        expected = (float) 0.1;
        actual = tax.getTaxRate();
        assertEquals(expected,actual, 0.0001);
    }
}
