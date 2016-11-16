package Game;

import com.google.gson.Gson;
import desktop_fields.Empty;
import desktop_resources.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;

import static Game.Language.setLanguage;

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

    public GameBoard() {

        //board = new Field[numberOfFields];
        board = loadBoardFromFile("board.cfg");
        showOnGui();

    }


    private void showOnGui() {


        desktop_fields.Field[] tempField = new desktop_fields.Field[40];

        for (int i = 0; i < 21; i++) {
            tempField[i] = board[i].toGUIField();

        }

        // Leaves the rest of the fields available in the GUI empty
        for (int i = 21; i < 40; i++) {

            tempField[i] = new Empty.Builder().build();
        }

        // Creates the GUI with the fieldarray
        GUI.create(tempField);
    }

    private Field[] loadBoardFromFile(String fileName) {

        try {
            Gson g = new Gson();
            Language lang = new Language();

            Field[] loadedFields = new Field[21];

            Path relativePath = Paths.get(fileName);
            String absolutePath = relativePath.toAbsolutePath().toString();

            BufferedReader fileReader = new BufferedReader(new FileReader(absolutePath));

            String line;
            int i = 0;
            while ((line = fileReader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                loadedFields[i] = g.fromJson(lineSplit[1], (Type) Class.forName("Game." + lineSplit[0]));
                loadedFields[i].setName(lang.getString(loadedFields[i].getName()));
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
            if (theField instanceof Ownable) {
                if (((Ownable) theField).getOwner() == player) {
                    num++;
                }
            }
        }

        return num;
    }
}
