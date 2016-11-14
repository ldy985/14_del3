package Game;

import desktop_resources.GUI;

/**
 * Created by razze on 10-11-2016.
 */
public class Refuge extends Field{

    private final int bonus;


    public Refuge(int no, String name, int bonus){

        super(no, name);

        this.bonus = bonus;


    }

    public void landOnField(Player player){

        player.getAccount().addBalance(bonus);
        GUI.showMessage("You landed on " + getName());
    }
}
