package Game;

//*******************************************************************
//  Account
//
// Keeps track of the balance, and adds/subtracts by the points on the board.
//*******************************************************************
public class Account {

    private int balance;

    // Sets the initial balance of the two players.
    public Account(int initialBalance) {
        balance = initialBalance;
    }

    // Adds/subtracts point to/from the balance by the given amount.
    public void addBalance(int amount) {
        balance = balance + amount;
    }
    // Return the balance.
    public int getBalance() {
        return balance;
    }

}