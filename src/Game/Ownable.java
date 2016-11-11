package Game;


/**
 * Shaker class, contains the Die objects
 *
 * Bugs: none known
 *
 * @author       Timothy Rasmussen
 * @version      v.0.1
 */
public abstract class Ownable extends Field {

    private int price;
    private Player owner;

    /**
     * The constructor of the Ownable type
     * @param number The id of the Field
     * @param price The price of the Field
     * @param name The name of the Field
     */
    public Ownable(int number, int price, String name) {
        super(number, name);
        this.price = price;
    }

    /**
     * Make sure all subclasses implement this method
     */
    protected abstract int getRent();

    /**
     * Gets the owner of an ownable Field
     * @return returns the owner.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of an ownable field
     * @param owner The new owner
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
