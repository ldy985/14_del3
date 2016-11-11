package Game;

/**
 * Created by shitface on 10-11-2016.
 */
public class Territory extends Ownable {

    private int rent;

    public Territory(int number, String name, int price, int rent) {

        super(number, price, name);
        this.rent = rent;

    }

    public void landOnField(Player player) {

        //This need to add game options.
        //GUI needs to be added.

        if (getOwner() == player) {

            return;
        }

        if (true) { //if somebody buys the field.

        setOwner(player);

        }

    }

    public int getRent() {

        return rent;

    }

}

