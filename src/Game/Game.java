package Game;


// Game entrypoint.
public class Game {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        // The GUI generates the fields on the board
        //gameController.initializePlayers();

        // The startGame() method is called to startGame the game
        gameController.startGame();

    }
}
