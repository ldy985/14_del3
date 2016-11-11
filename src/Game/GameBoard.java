package Game;

public class GameBoard {

    Field[] Board = new Field[21];

    public Field getField(int num) {
        if (num <= Board.length) {
            return Board[num];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getNoOfFleetsOwned(Player player) {
        int num = 0;

        for (Field theField : Board) {
            if (theField instanceof Ownable) {
                if (((Ownable) theField).getOwner() == player) {
                    num++;
                }
            }
        }

        return num;
    }
}
