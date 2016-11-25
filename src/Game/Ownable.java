package Game;


/**
 * Shaker class, contains the Die objects
 * <p>
 * Bugs: none known
 *
 * @author Timothy Rasmussen
 * @version v.0.1
 */
public abstract class Ownable extends Field {

    private final int price;
    private Player owner;

    /**
     * The constructor of the Ownable type
     *
     * @param number The id of the Field
     * @param name   The name of the Field
     * @param price  The price of the Field
     */
    public Ownable(int number, String name, int price) {
        super(number, name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Make sure all subclasses implement this method
     */
    protected abstract int getRent();

    /**
     * Gets the owner of an ownable Field
     *
     * @return returns the owner.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Sets the owner of an ownable field
     *
     * @param owner The new owner
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void landOnField(Player player) {

        // No one owns the field and the player has the money to buy it
        if (owner == null && price <= player.getBalance()) {


            final String question = player.getName() + " " + (Language.getString("turn1") + " " +
                    Language.getString("buy1") + " " + getName() + " " + Language.getString("buy2") + " " + price + " ?");

            final String answer1 = Language.getString("no");
            final String answer2 = Language.getString("yes");

            // Checks whether the player wants to buy
            if (InterfaceController.getUserButtonPressed(question, answer1, answer2) == answer2) {

                player.addBalance(-price);
                player.addRealEstateValue(price);
                this.setOwner(player);
                InterfaceController.showMessage(player.getName() + " " + Language.getString("bought") + " " + getName());

            }
        }
        //Someone else owns the field
        if (owner != player && owner != null) {
            player.addBalance(-getRent());
            owner.addBalance(getRent());
        }

    }
}
