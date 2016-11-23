package Game;

import java.util.Random;


/**
 * Die class that has the functions of a real die
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @author Casper Bodskov
 * @author Lasse Dyrsted
 * @author Michael Klan
 * @author Rasmus Blichfeldt
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public class Die {

    private final Random rand = new Random();

    private int faceValue;

    /**
     * Rolls the die
     */
    public void roll() {

        faceValue = rand.nextInt(6) + 1;

    }

    /**
     * @return Returns the value of the die
     */
    public int getFaceValue() {

        return faceValue;
    }

}
