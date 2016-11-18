package Game;

import desktop_resources.GUI;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class Account {

    private int balance;

    /**
     * Sets the initial balance of the two players
     *
     * @param initialBalance The initial balance
     */
    public Account(int initialBalance) {
        balance = initialBalance;
    }

    /**
     * Adds/subtracts point to/from the balance by the given amount
     *
     * @param amount the amount to add to balance
     */
    public void addBalance(int amount) {
        balance = balance + amount;
        InterfaceController.setBalance(balance);
    }

    /**
     * Return the balance
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

}