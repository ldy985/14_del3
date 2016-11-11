package Game;

public class Fleet extends Ownable {

    private final int RENT_1 = 500;
    private final int RENT_2 = 1000;
    private final int RENT_3 = 2000;
    private final int RENT_4 = 4000;
    private int numberOfFleets;

    public Fleet(int noOfFleets, String name, int price) {

        super(noOfFleets, price, name);

    }

    public void landOnField(Player player){      

        numberOfFleets = GameBoard.getNoOfFleetsOwned(player);
        this.player = player;

    }

    public int getRent() {

        switch (numberOfFleets){
            case 1:
                rent = RENT_1;
                break;
            case 2:
                rent = RENT_2;
                break;
            case 3:
                rent = RENT_3;
                break;
            case 4:
                rent = RENT_4;
                break;
        }

        return rent;

    }

}
