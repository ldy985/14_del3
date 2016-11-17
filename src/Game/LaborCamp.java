package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Casper Bodskov
 * @version      v.0.1
 */

public class LaborCamp extends Ownable {

    private final int baseRent;


    public LaborCamp(int number, String name, int price, int baseRent) {

        super(number, name, price);
        this.baseRent = baseRent;

    }


    public int getRent() {

        // Receives the sum of the dice rolled
        int sum = GameController.getShaker().getSum();

        // Calculates the base rent
        return sum * (-baseRent);
    }
}
