package Game;


/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */

public class Player {

    private final String name;
    private final Account account;
    private int realEstateValue = 0;
    private int onField = 0;

    //
    public Player(String playerName, int startBalance) {
        name = playerName;
        account = new Account(startBalance);
    }

    public int getRealEstateValue() {
        return realEstateValue;
    }

    public void addRealEstateValue(int newRealEstateValue) {
        this.realEstateValue = realEstateValue + newRealEstateValue;
    }

    // Returns the name
    public String getName() {
        return name;
    }

    public int getOnField() {
        return onField;
    }

    public void setOnField(int onField) {
        this.onField = onField;
    }

    public void addBalance(int balance) {
        account.addBalance(balance);
        InterfaceController.setBalance(this, account.getBalance());
    }
    public int getBalance() {
        return account.getBalance();
    }

}
