package Test;

import Game.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Testes the Refuge class
 * <p>
 * Bugs: none known
 *
 * @author Mathias Larsen
 * @version v.0.3
 */
public class RefugeTest {


    private Player player;
    private GameBoard gameBoard;
    private Refuge refuge1;
    private Refuge refuge2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterfaceController.setInterfaceMode(InterfaceController.Mode.Test);
        Language.setLanguage("english");
    }

        @Before
        public void setUp() throws Exception {
            this.player = new Player("Player1", 30000);
            this.gameBoard = new GameBoard(21);
            this.refuge1 = (Refuge) gameBoard.getField(6);
            this.refuge2 = (Refuge) gameBoard.getField(21);
        }


        @Test
        public void testEntities() {

            assertNotNull(this.player);

            assertNotNull(this.gameBoard);

            assertNotNull(this.refuge1);
            assertNotNull(this.refuge2);

            assertTrue(this.refuge1 instanceof Refuge);
            assertTrue(this.refuge2 instanceof Refuge);
            assertTrue(this.gameBoard instanceof GameBoard);
            assertTrue(this.player instanceof Player);
        }

        @Test
        public void testBonus(){
            int expected = 5000;
            int actual = refuge1.getBonus();
            assertEquals(expected,actual);

            expected = 500;
            actual = refuge2.getBonus();
            assertEquals(expected,actual);
        }

        @Test
        public void testName(){
            String expected = "Walled city";
            String actual = refuge1.getName();
            assertEquals(expected,actual);

            expected = "Monastery";
            actual = refuge2.getName();
            assertEquals(expected,actual);

            refuge1.setName("Change");
            expected = "Change";
            actual = refuge1.getName();
            assertEquals(expected,actual);
        }

        @Test
        public void testLandOnField() {
            int expected = 30000;
            int actual = player.getBalance();
            assertEquals(expected,actual);

            refuge1.landOnField(player);
            expected = 35000;
            actual = player.getBalance();
            assertEquals(expected,actual);

            refuge2.landOnField(player);
            expected = 35500;
            actual = player.getBalance();
            assertEquals(expected,actual);
        }

    }
