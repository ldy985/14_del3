package Game;

import desktop_codebehind.Car;
import desktop_fields.Empty;
import desktop_fields.Shipping;
import desktop_resources.GUI;


/**
 * Chooses whether we run a console version of the program or the GUI
 * <p>
 * Bugs: none known
 *
 * @author Lasse Dyrsted
 * @version v.0.1
 */
public class InterfaceController {

    private static Mode mode;
    private static String preDefinedAnswer;

    private InterfaceController() {
    }

    public static void setPreDefinedAnswer(String preDefinedAnswer) {
        InterfaceController.preDefinedAnswer = preDefinedAnswer;
    }

    public static void setInterfaceMode(Mode mode) {
        InterfaceController.mode = mode;
    }

    public static void addPlayer(String name, int start_balance, Car build) {
        switch (mode) {

            case GUI:
                GUI.addPlayer(name, start_balance, build);
            case Test:
                break;
        }

    }

    public static String getUserString(String s) {

        switch (mode) {

            case GUI:
                return GUI.getUserString(s);
            case Test:
                System.out.println(s);
                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static void setDice(int faceValue1, int faceValue2) {
        switch (mode) {

            case GUI:
                GUI.setDice(faceValue1, faceValue2);

            case Test:
                break;
        }
    }

    public static void removeAllCars(String name) {
        switch (mode) {

            case GUI:
                GUI.removeAllCars(name);
            case Test:
                break;
        }

    }

    public static void setCar(int onField, String name) {
        switch (mode) {

            case GUI:
                GUI.setCar(onField, name);
            case Test:
                break;
        }

    }

    public static void showMessage(String won) {
        switch (mode) {

            case GUI:
                GUI.showMessage(won);
            case Test:
                System.out.println(won);
                break;
        }

    }

    public static void close() {
        switch (mode) {

            case GUI:
                GUI.close();
            case Test:
                break;
        }

    }

    public static String getUserSelection(String s, String... s1) {
        switch (mode) {
            case GUI:
                return GUI.getUserSelection(s, s1);
            case Test:
                System.out.print(s);
                System.out.print(" [");

                for (String item : s1) {
                    System.out.print(item + " ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static String getUserButtonPressed(String s, String... no) {

        switch (mode) {
            case GUI:
                return GUI.getUserButtonPressed(s, no);
            case Test:
                System.out.print(s);
                System.out.print(" [");

                for (String item : no) {
                    System.out.print(item + " ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static void setBalance(int balance) {
        switch (mode) {

            case GUI:
                GUI.setBalance(GameController.getCurrentPlayer().getName(), balance);
                break;
            case Test:
                System.out.println("The players balance was set to " + balance);
                break;
        }
    }

    /**
     * Creates the GUI based on field array.
     */
    public static void showOnGui(Field[] board) {

        switch (mode) {

            case GUI:
                desktop_fields.Field[] tempField = new desktop_fields.Field[40];

                for (int i = 0; i < board.length; i++) {
                    tempField[i] = convertToGUI(board[i]);
                }


                // Leaves the rest of the fields available in the GUI empty
                for (int i = 21; i < 40; i++) {
                    if (i == 35) {
                        tempField[35] = new Shipping.Builder().setTitle("<b>Rules").setDescription("2-6 players play. Players roll 2 dice, and move their pieces around the board. If a player runs out of gold they are removed from the game. Remaining players continue with the game. Last player standing wins.").setPicture("").setSubText("").build();
                    } else {
                        tempField[i] = new Empty.Builder().build();
                    }
                }

                // Creates the GUI with the fieldarray
                GUI.create(tempField);
                break;
            case Test:
                System.out.println("Create GUI call");
                break;
        }


    }

    public static desktop_fields.Field convertToGUI(Field theField) {
        desktop_fields.Shipping.Builder a = new desktop_fields.Shipping.Builder()
                .setTitle(theField.getName())
                .setPicture(null);
        return a.build();
    }

    public enum Mode {
        GUI,
        Test
    }
}
