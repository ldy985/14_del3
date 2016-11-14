package Game;

/**
 * Created by shitface on 10-11-2016.
 */
public class Territory extends Ownable {

    private final int rent;

    public Territory(int number, String name, int price, int rent) {

        super(number, price, name);
        this.rent = rent;

    }

    public int getRent() {
        return rent;
    }

}

