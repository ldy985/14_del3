package Game;

public class LaborCamp extends Ownable {

    private int baseRent;
    private int no;
    private int price;
    private String name;
    private boolean buyfield;
    private boolean ableToBuy;


    public LaborCamp(int no, String name, int price) {

        super(no, price, name);

        this.no = no;
        this.name = name;
        this.price = price;
    }

    public void landOnField(Player player) {

        // If the player doesn't own the field
        if (getOwner() != player) {

            // If no-one owns the field
            if (getOwner() == null) {

                // Checks if the player has enough funds in their account
                if (price <= player.getAccount().getBalance()) {

                    ableToBuy = true;
                }

                // Checks whether the player wants to buy
                if (buyfield && ableToBuy) {

                    player.getAccount().addBalance(price);
                    setOwner(player);
                }
                //If another player owns the field
            } else {

                player.getAccount().addBalance(getRent());
            }

        }

    }

    @Override
    public int getRent() {

        // Receives the sum of the dice rolled
        int sum = GameController.getShaker().getSum();

        // Calculates the base rent
        baseRent = sum * (-100);

        return baseRent;
    }

}
