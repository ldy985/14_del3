package Game;

import java.util.Random;

/**
 * Created by razze on 10-11-2016.
 */
public class Die {

    private final Random rand = new Random();

    private int faceValue;

    public void roll() {

        faceValue = rand.nextInt(6) + 1;

    }

    public int getFaceValue() {

        return faceValue;
    }

}
