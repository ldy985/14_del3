package Game;

import desktop_codebehind.Car;
import desktop_codebehind.Player;
import desktop_resources.GUI;
import java.util.*;

import java.awt.*;

import static desktop_codebehind.FieldFactory.fields;

/**
 * The main flow of the game.
 *
 * Bugs: none known
 *
 * @author       Mathias S Larsen (2016)
 * @version      v.0.1
 */

public class GameController {

    private Shaker shaker;
    private ArrayList<Player> players = new ArrayList<Player>(); //creates an ArrayList that can contain Player objects
    private GameBoard gameBoard;
    //private boolean gameWon = false;


    public GameController(){

        gameBoard = new GameBoard(21); //creates a Gameboard object.
        shaker = new Shaker(2); //creates a shaker with 2 dice.
    }

    private void initializePlayers(){
        int numberOfPlayers = GUI.getUserInteger("How many players?", 2,6);

        for (int i = 0; i < numberOfPlayers ; i++){
            String name = GUI.getUserString("What is Player" + (i+1) + "'s name?"); //the + (i+1) changes the number so system prints player1 then player2...
            players.add = new Player(name); //creates a new player object.

            // Adds player to the GUI
            // Adds a car object which has a new color, specified by a random-method between the integers 0-255
            GUI.addPlayer(player.getName(), 30000, new Car.Builder()
                    .primaryColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)))
                    .build());
        }

    }

    private void displayDice(Shaker shaker) {

        // Declares face values to show the die in the GUI
        int faceValue1 = shaker.getDice()[0].getFaceValue();
        int faceValue2 = shaker.getDice()[1].getFaceValue();


        // Displays the dice on the board
        GUI.setDice(faceValue1, faceValue2);
    }

    private void handleFieldAction(int sum, Player player) {


        //"Moves" the car on the board by removing it in the previous location
        // and then set it to the new location.
        GUI.removeAllCars(player.getName());
        GUI.setCar(sum - 1, player.getName());

        // Finds the modifier of the specific field.
        int points = fields[sum - 2].getRent();

        // Adds or subtracts points to/from the players balance
        player.getAccount().addBalance(points);

        // Displays new balance in the GUI
        GUI.setBalance(player.getName(), player.getAccount().getBalance());

        GUI.showMessage(fields[sum - 2].getActionText());

    }

    public void startGame(){

        initializePlayers();

        //sets player1 to be the current player.
        Player player1 = players.get(0);
        player1.isTurn(true);

        //loop as long as more than one player is in the game (not bankroupt)
        while(players.size() > 1){

            //go though all the players.
            for(int i = 0; i <= players.size() - 1; i++){

                Player currentPlayer = players.get(i);
                //Checks which player has the turn and that the page has not been won.
                //the system will go uot of this loop when there is 1 player left in the game
                //therefore that player has won.
                while(currentPlayer.getIsTurn() && players.size()>1){

                    //rolls the dice
                    shaker.shake();

                    //displayes the dice in the GUI
                    displayDice(shaker);

                    //moves the players avitar on the gameboard in the GUI
                    handleFieldAction(shaker.getSum(), currentPlayer);

                    //stores the players location on the gameboard
                    if(currentPlayer.getOnField()+shaker.getSum() <= gameBoard.fieldArray.lenght()){
                        currentPlayer.setOnField(currentPlayer.getOnField()+shaker.getSum());
                    }
                    else{
                        currentPlayer.setOnField(currentPlayer.getOnField()+shaker.getSum() - gameBoard.fieldArray.lenght());
                    }

                    //controles what happens when the player  lands on a specific field.
                    Field currentField = gameBoard.getField(currentPlayer.getOnField());
                    currentField.landOnField(currentPlayer);

                    //removes bankroupt players from the game
                    if(currentPlayer.getBalance() <= 0){
                        players.remove(i);
                    }

                    //moves the turn to the next player
                    if(i + 1 <= players.size() - 1){
                        players.get(i+1).setIsturn(true);
                    }
                    else{
                        players.get(0).setIsTurn(true);
                    }

                    currentPlayer.setIsTurn(false);

                }

                //gets displayed when a winner has been found.
                GUI.showMessage(players.get(i).getName() + "Won");
            }
        }
        GUI.close();
    }



}
