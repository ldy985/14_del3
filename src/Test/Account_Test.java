package Test;

public class Account_Test {

    //Only method is the addBalance and getBalance.
    private int balance = 100;
    private int amount = 100;

    public Account_Test(){

        balance = balance + amount;
        System.out.println(balance+"  = Expected 200");
    }




}
    /*
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