package Game;


/**
 * Created by Timothy Rasmussen on 10-11-2016.
 */
public abstract class Ownable extends Field {

    private int price;
    private Player owner;

    public Ownable(int number, int price, String name) {
        super(name, number);
        this.price = price;
    }

    protected abstract int getRent();

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
