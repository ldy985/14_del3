package Game;


//*******************************************************************
//  Player
//
// Represents each player as an object.
// Keeps track of whether the player has his turn, has won, and the car spot for the previous turn.
//*******************************************************************
public class Player {

    private final String name;
    private final Account account;
    private int realEstateValue = 0;
    private int onField;

    //
    public Player(String playerName, int startBalance) {
        name = playerName;
        account = new Account(startBalance);
    }

    public int getRealEstateValue() {
        return realEstateValue;
    }

    public void setRealEstateValue(int realEstateValue) {
        this.realEstateValue = realEstateValue;
    }

    // Returns the account object.
    public Account getAccount() {
        return account;
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
}
