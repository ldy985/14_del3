package Test;

public class Account_Test {

        private int balance;

        // Sets the initial balance of the two players.
        public Account(int initialBalance) {
            balance = initialBalance;
        }

        // Adds/subtracts point to/from the balance by the given amount.
        public boolean addBalance(int amount) {
            balance = balance + amount;
            return balance;
        }

        // Return the balance.
        public int getBalance() {
            return balance;
        }

    }