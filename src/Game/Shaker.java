package Game;

/**
 * Shaker class, contains the Die objects
 *
 * Bugs: none known
 *
 * @author       Mathias S Larsen (2016)
 * @author       Casper Bodskov
 * @author       Lasse Dyrsted
 * @author       Michael Klan
 * @author       Rasmus Blichfeldt
 * @author       Timothy Rasmussen
 * @version      v.0.1
 */
public class Shaker {

    //Initializing variables
    private int sum;
    private final Die[] dice;


    /**
     * Creates the Dice in the shaker
     * @param dieCount Amount of Dice to create
     */
    public Shaker(int dieCount) {
        dice = new Die[dieCount];
        for (int i = 0; i < dieCount; i++) {
            dice[i] = new Die();
        }
    }

    /**
     * Rolls all the Dice
     */
    public void shake() {
        sum = 0;
        for (Die die : this.dice) {
            die.roll();
            sum += die.getFaceValue();
        }
    }

    /**
     * Gets the sum of the rolled Dice
     */
    public int getSum() {
        return sum;
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    /**
     * Gets the Dice objects in the Shaker.
     */
    public Die[] getDice() {
        return dice;
    }

}



