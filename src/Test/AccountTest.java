package Test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Account class
 * <p>
 * Bugs: none known
 *
 * @author Casper Bodskov
 * @version v.0.1
 */

public class AccountTest {

    private Game.Account newAccount;

    @Before
    private void setUp() throws Exception {

        newAccount = new Game.Account(1000);

    }

    @Test
    public void addBalance() throws Exception {

        newAccount.addBalance(100);

        //tests if the addBalance works
        assertEquals(1100, newAccount.getBalance());
    }

    @Test
    public void getBalance() throws Exception {

        //tests if the getBalance returns the right amount and if the starting balance is 1000 points
        assertEquals(1000, newAccount.getBalance());
    }


}