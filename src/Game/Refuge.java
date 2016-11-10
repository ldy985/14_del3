package Game;

/**
 * Created by razze on 10-11-2016.
 */
public class Refuge extends Field{

    private int bonus;


    public Refuge(int no, String name, int bonus){

        super(no, name);

        this.bonus = bonus;

    }

    public void landOnField(Player player){

        player.getAccount().addBalance(bonus);

    }


}
