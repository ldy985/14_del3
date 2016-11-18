package Game;

import desktop_resources.GUI;
import static Game.Language.getString;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Rasmus Blichfeldt
 * @version      v.0.1
 */

public class Refuge extends Field{

    private final int bonus;


    public Refuge(int no, String name, int bonus){

        super(no, name);

        this.bonus = bonus;


    }

    public void landOnField(Player player){

        player.getAccount().addBalance(bonus);
        InterfaceController.showMessage(getString("landed") + getName());
    }
}
