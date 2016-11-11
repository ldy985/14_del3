package Game;


/**
 * Created by Timothy Rasmussen on 10-11-2016.
 */
public abstract class Field {

    private String name;
    private int number;

    public Field(int number, String name){

        this.name = name;
        this.number = number;
    }

    public abstract void landOnField(Player player);

}
