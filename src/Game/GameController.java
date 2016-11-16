package Game;


import desktop_codebehind.Car;
import desktop_resources.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static Game.Language.getString;
import static Game.Language.setLanguage;

/**
 * The main flow of the game.
 * <p>
 * Bugs: none known
 *
 * @author Mathias S Larsen (2016)
 * @version v.0.1
 */

public class GameController {

    private static Shaker shaker;
    private static Player currentPlayer;
    private static final int FIELD_COUNT = 21;
    private final int START_BALANCE = 30000;
    private final ArrayList<Player> players = new ArrayList<Player>(); //creates an ArrayList that can contain Player objects

    public static GameBoard getGameBoard() {
        return gameBoard;
    }

    private static final GameBoard gameBoard = new GameBoard();

    public GameController() {

         //creates a Gameboard object.
        shaker = new Shaker(2); //creates a shaker with 2 dice.

    }
    //private boolean gameWon = false;

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static Shaker getShaker() {
        return shaker;
    }

    private void initializePlayers() {

        int numberOfPlayers = 2; // TODO: 11-11-2016 GUI
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = GUI.getUserString(getString("name1") + (i + 1) + getString("name2")); //the + (i+1) changes the number so system prints player1 then player2...
            players.add(new Player(name, START_BALANCE)); //creates a new player object.

            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            GUI.addPlayer(players.get(i).getName(), START_BALANCE, new Car.Builder()
                    .primaryColor(randomColor())
                    .build());
        }

    }

    private Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        GUI.setDice(faceValue1, faceValue2);
    }

    private void movePlayer(Player thisPlayer) {

        //stores the players location on the gameboard
        if (thisPlayer.getOnField() + shaker.getSum() <= FIELD_COUNT) {
            thisPlayer.setOnField(thisPlayer.getOnField() + shaker.getSum());
        } else {
            thisPlayer.setOnField(thisPlayer.getOnField() + shaker.getSum() - FIELD_COUNT);
        }

        //"Moves" the car on the board by removing it in the previous location
        // and then set it to the new location.
        GUI.removeAllCars(thisPlayer.getName());
        GUI.setCar(thisPlayer.getOnField(), thisPlayer.getName());

    }

    public void startGame() {

        initializePlayers();

        //loop as long as more than one player is in the game (not bankroupt)
        while (players.size() > 1) {

            //go though all the players.

            for (int i = 0; i < players.size(); i++) {
                currentPlayer = players.get(i);


                //rolls the dice
                shaker.shake();

                //displayes the dice in the GUI
                displayDice(shaker);

                //moves the players avitar on the gameboard in the GUI
                movePlayer(currentPlayer);


                //controles what happens when the player lands on a specific field.
                Field currentField = gameBoard.getField(currentPlayer.getOnField());
                currentField.landOnField(currentPlayer);

                //removes bankroupt players from the game
                if (currentPlayer.getAccount().getBalance() <= 0) {
                    players.remove(currentPlayer);
                    break;//Stop the loop when we remove an element because we use foreach else we get a pointer error
                }


            }

        }

        //gets displayed when a winner has been found.
        GUI.showMessage(players.get(0).getName() + getString("won"));

        GUI.close();
    }
}
