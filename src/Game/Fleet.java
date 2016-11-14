package Game;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Casper Bodskov
 * @version      v.0.1
 */

public class Fleet extends Ownable {

    private final int RENT_1 = 500;
    private final int RENT_2 = 1000;
    private final int RENT_3 = 2000;
    private final int RENT_4 = 4000;

    public Fleet(int noOfFleets, String name, int price) {

        super(noOfFleets, price, name);

    }


    public int getRent() {
        switch (GameController.getGameBoard().getNoOfFleetsOwned(GameController.getCurrentPlayer())) {
            case 1:
                return RENT_1;
            case 2:
                return RENT_2;
            case 3:
                return RENT_3;
            case 4:
                return RENT_4;
            default:
                return 0; //Should never happen
        }
    }

}
