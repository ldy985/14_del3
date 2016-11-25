package Game;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GameBoard encapsulates all the Fields used in the game
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class GameBoard {

    private final Field[] board;
    private int numberOfFields;

    /**
     * The constructor of the class GameBoard
     *
     * @param number The number of fields we want on the board
     */
    public GameBoard(int number) {

        numberOfFields = number;

        //loads file from resource folder
        board = loadBoardFromFile("board.cfg");
        InterfaceController.showOnGui(board);

    }

    public Field[] getBoard() {
        return board;
    }

    /**
     * Creates field objects from a properties file, converted through Gson.
     *
     * @param fileName Name of the ressource file
     * @return
     */
    public Field[] loadBoardFromFile(String fileName) {

        try {
            Gson g = new Gson();

            Field[] loadedFields = new Field[21];

            Path relativePath = Paths.get("resources\\" + fileName);
            String absolutePath = relativePath.toAbsolutePath().toString();

            BufferedReader fileReader = new BufferedReader(new FileReader(absolutePath));

            String line;
            int i = 0;
            while ((line = fileReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                loadedFields[i] = g.fromJson(lineSplit[1], (Type) Class.forName("Game." + lineSplit[0]));
                loadedFields[i].setName(Language.getString(loadedFields[i].getName()));
                i++;

            }

            fileReader.close();

            return loadedFields;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;// only happens if there was an error
    }


    /**
     * Gets the field object of an index on the board
     *
     * @param num the position on the board from 1
     * @return the field object
     */
    public Field getField(int num) {
        if (num <= board.length) {
            return board[num - 1];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Gets the amount of fleets owned by a specific player
     *
     * @param player the player
     * @return the amount of fleets the player currently owns
     */
    public int getNoOfFleetsOwned(Player player) {
        int num = 0;

        for (Field theField : board) {
            if (theField instanceof Fleet) {
                if (((Fleet) theField).getOwner() == player) {
                    num++;
                }
            }
        }

        return num;
    }

    public void deleteOwnership(Player player) {

        for (Field theField : board) {
            if (theField instanceof Ownable) {
                if (((Ownable) theField).getOwner() == player) {
                    ((Ownable) theField).setOwner(null);
                }
            }
        }


    }
}
