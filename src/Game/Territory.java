package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Timothy Rasmussen
 * @version      v.0.1
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

