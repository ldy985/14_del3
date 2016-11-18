package Game;

import static Game.Language.setLanguage;

/**
 * Keeps track of the balance, and adds/subtracts by the points on the board.
 *
 * Bugs: none known
 *
 * @author       Rasmus Blichfeld
 * @version      v.0.1
 */

// Game entrypoint.
public class Game {


    public static void main(String[] args) {

        // Selects the language
        setLanguage("english");

        InterfaceController.setInterfaceMode(InterfaceController.Mode.GUI);

        GameController gameController = new GameController();

        // The GUI generates the fields on the board
        //gameController.initializePlayers();

        // The startGame() method is called to startGame the game
        gameController.startGame();

    }
}
