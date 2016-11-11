package Game;

/**
 * GameBoard encapsulates all the Fields used in the game
 *
 * Bugs: none known
 *
 * @author       Lasse Dyrsted
 * @version      v.0.1
 */
public class GameBoard {

    Field[] Board = new Field[21];

    /**
     * Gets the field object of an index on the board
     * @param num the position on the board from 1
     * @return the field object
     */
    public Field getField(int num) {
        if (num <= Board.length) {
            return Board[num-1];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Gets the amount of fleets owned by a specific player
     * @param player the player
     * @return the amount of fleets the player currently owns
     */
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
