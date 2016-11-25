package Game;


/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt
 * @version v.0.1
 */

public class Refuge extends Field {

    private final int bonus;


    public Refuge(int no, String name, int bonus) {

        super(no, name);
        this.bonus = bonus;

    }

    public int getBonus() {
        return bonus;
    }

    public void landOnField(Player player) {

        player.addBalance(bonus);
    }
}
