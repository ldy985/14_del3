package Test;

import Game.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Tests the Tax class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.2
 */
public class TaxTest {

    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Tax tax1;
    private Tax tax2;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }

    @Before
    public void setUp() throws Exception {
        this.player1 = new Player("Player1", 30000);
        this.player2 = new Player("Player2", 30000);
        this.gameBoard = new GameBoard(21);
        this.tax1 = (Tax) gameBoard.getField(4);
        this.tax2 = (Tax) gameBoard.getField(16);

    }

    @Test
    public void testEntities() {
        assertNotNull(this.player1);

        assertNotNull(this.gameBoard);
        assertNotNull(this.tax1);
        assertNotNull(this.tax2);

        assertTrue(this.player1 instanceof Player);
        assertTrue(this.player2 instanceof Player);

        assertTrue(this.gameBoard instanceof GameBoard);

        assertTrue(this.tax1 instanceof Tax);
        assertTrue(this.tax2 instanceof Tax);
    }

    @Test
    public void testName() throws Exception {

        String expected = "Goldmine";
        String actual = tax1.getName();
        assertEquals(expected, actual);

        expected = "Caravan";
        actual = tax2.getName();
        assertEquals(expected,actual);

        tax1.setName("Change");
        expected = "Change";
        actual = tax1.getName();
        assertEquals(expected,actual);

    }

    @Test
    public void testTaxAmount(){
        int expected = 2000;
        int actual = tax1.getTaxAmount();
        assertEquals(expected,actual);

        expected = 4000;
        actual = tax2.getTaxAmount();
        assertEquals(expected,actual);
    }

    @Test
    public void testTaxRate(){
        float expected = 1.0f;
        float actual = tax1.getTaxRate();
        assertEquals(expected,actual,0.001);

        expected = 0.1f;
        actual = tax2.getTaxRate();
        assertEquals(expected,actual, 0.001);
    }


    @Test
    public void testLandOnField(){

        //testes that the players start account is correct.
        int expected = 30000;
        int actual = player1.getBalance();
        assertEquals(expected,actual);

        //player lands on tax field
        tax1.landOnField(player1);

        //testes that the tax (2000) have been payed
        expected = 28000;
        actual = player1.getBalance();
        assertEquals(expected,actual);

        //player choses to pay 4000 in tax
        InterfaceController.setPreDefinedAnswer("4000");
        tax2.landOnField(player1);

        //tests that the tax (4000) have been payed
        expected = 24000;
        actual = player1.getBalance();
        assertEquals(expected,actual);

        //player chooses to pay 10% of total value (realestate + money on account) in tax
        InterfaceController.setPreDefinedAnswer("10%");
        tax2.landOnField(player1);

        expected = 21600;
        actual = player1.getBalance();
        assertEquals(expected,actual);

        //adds value to players realestate
        player1.addRealEstateValue(10000);

        //player chooses to pay 10% of total value (realestate + money on account) in tax
        InterfaceController.setPreDefinedAnswer("10%");
        tax2.landOnField(player1);

        expected = 18440;
        actual = player1.getBalance();
        assertEquals(expected,actual);


    }
}