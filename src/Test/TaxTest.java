package Test;

import Game.Player;
import Game.Tax;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests the Tax class
 *
 * Bugs: none known
 *
 * @author       Mathias Larsen
 * @version      v.0.1
 */
public class TaxTest {

    private Player player;
    private Tax tax200;
    private Tax tax0;
    private Tax taxneg200;
    private Tax tax10Pct;


    @Before
    public void setUp() throws Exception {
        this.player = new Player("Anders And", 1000);
        this.tax200 = new Tax(1, "Helle +200", 200, 1);
        this.tax0 = new Tax(2, "Helle 0", 0, 1);
        this.taxneg200 = new Tax(3, "Helle -200", -200, 1);
        this.tax10Pct = new Tax(4, "10Pct", 4000, 0.1f);
    }

    @After
    public void tearDown() throws Exception {

        this.player = new Player("Anders And", 1000);
    }

    @Test
    public void testEntities() {
        Assert.assertNotNull(this.player);

        Assert.assertNotNull(this.tax200);
        Assert.assertNotNull(this.tax0);
        Assert.assertNotNull(this.taxneg200);
        Assert.assertNotNull(this.tax10Pct);

        Assert.assertTrue(this.tax200 instanceof Tax);
        Assert.assertTrue(this.tax0 instanceof Tax);
        Assert.assertTrue(this.taxneg200 instanceof Tax);
        Assert.assertTrue(this.tax10Pct instanceof  Tax);
    }

    @Test
    public void testLandOnField200() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.taxneg200.landOnField(this.player);

        expected = 1000 + 200;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLandOnField200Twice() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.taxneg200.landOnField(this.player);
        this.taxneg200.landOnField(this.player);

        expected = 1000 + 200 + 200;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLandOnField0() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.tax0.landOnField(this.player);

        expected = 1000;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLandOnField0Twice() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.tax0.landOnField(this.player);
        this.tax0.landOnField(this.player);

        expected = 1000;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLandOnFieldNeg200() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.taxneg200.landOnField(this.player);

        expected = 1000 - 200;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testLandOnFieldNeg200Twice() {
        int expected = 1000;
        int actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);

        //Perform the action to be tested
        this.taxneg200.landOnField(this.player);
        this.taxneg200.landOnField(this.player);

        expected = 1000 - 200 - 200;
        actual = player.getAccount().getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLandOnField10Pct(){

        int expected = 0;
        int actual = player.getRealEstateValue();
        assertEquals(expected, actual);

        player.addRealEstateValue(1000);

        expected = 1000;
        actual = player.getRealEstateValue();
        assertEquals(expected, actual);



    }

    @Test
    public void testName() throws Exception {

        String expected = "Helle +200";
        String actual = tax200.getName();
        assertEquals(expected, actual);

        tax200.setName("Change");

        expected = "change";
        actual = tax200.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetAmount() throws Exception{

    }

}