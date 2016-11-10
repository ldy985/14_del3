package Game;

public class Fleet extends Ownable {

    private final int RENT_1 = 500;

    private final int RENT_2 = 1000;

    private final int RENT_3 = 2000;

    private final int RENT_4 = 4000;

    private int rent=0;

    private LaborCamp(int no, String name, int price) {

        this.no=no;
        this.name=name;
        this.price=price;
        GameBoard gB= new GameBoard();

    }

    private int getRent() {

        int NoEllerNoget=gB.getNoOfFleetsOwned(Player player);
        switch (NoEllerNoget){
            case 1:
                rent=RENT_1;
                break;
            case 2:
                rent=RENT_2;
                break;
            case 3:
                rent=RENT_3;
                break;
            case 4:
                rent=RENT_4;
                break;
        }

        return rent;

    }

}
