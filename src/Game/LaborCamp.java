package Game;

public class LaborCamp extends Ownable {

    private final int baseRent;


    public LaborCamp(int number, String name, int price, int baseRent) {

        super(number, price, name);
        this.baseRent = baseRent;

    }


    public int getRent() {

        // Receives the sum of the dice rolled
        int sum = GameController.getShaker().getSum();

        // Calculates the base rent
        return sum * (-baseRent);
    }
}
