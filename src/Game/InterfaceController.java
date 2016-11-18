package Game;

import desktop_codebehind.Car;
import desktop_resources.GUI;


/**
 * Created by ldylab on 17-11-2016.
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
            case Console:
                break;
            case GUI:
                GUI.addPlayer(name, start_balance, build);
            case Test:
                break;
        }

    }

    public static String getUserString(String s) {

        switch (mode) {
            case Console:
                break;
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
            case Console:
                break;
            case GUI:
                GUI.setDice(faceValue1, faceValue2);

            case Test:
                break;
        }
    }

    public static void removeAllCars(String name) {
        switch (mode) {
            case Console:
                break;
            case GUI:
                GUI.removeAllCars(name);
            case Test:
                break;
        }

    }

    public static void setCar(int onField, String name) {
        switch (mode) {
            case Console:
                break;
            case GUI:
                GUI.setCar(onField, name);
            case Test:
                break;
        }

    }

    public static void showMessage(String won) {
        switch (mode) {
            case Console:
                System.out.println(won);
                break;
            case GUI:
                GUI.showMessage(won);
            case Test:
                System.out.println(won);
                break;
        }

    }

    public static void close() {
        switch (mode) {
            case Console:
                break;
            case GUI:
                GUI.close();
            case Test:
                break;
        }

    }

    public static String getUserSelection(String s, String... s1) {
        switch (mode) {
            case Console:
                break;
            case GUI:
                return GUI.getUserSelection(s, s1);
            case Test:
                System.out.print(s);
                System.out.print(" [");

                for (String item: s1) {
                    System.out.print(item+" ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static String getUserButtonPressed(String s, String... no) {

        switch (mode) {
            case Console:
                break;
            case GUI:
                return GUI.getUserButtonPressed(s, no);
            case Test:
                System.out.print(s);
                System.out.print(" [");

                for (String item: no) {
                    System.out.print(item+" ");
                }
                System.out.print("] ");

                System.out.println(preDefinedAnswer);
                return preDefinedAnswer;
        }
        return ""; //Should not happen

    }

    public static void setBalance(int balance) {
        switch (mode) {
            case Console:
                break;
            case GUI:
                GUI.setBalance(GameController.getCurrentPlayer().getName(), balance);
                break;
            case Test:
                System.out.println("The players balance was set to " + balance);
                break;
        }
    }

    public enum Mode {
        GUI,
        Console,
        Test,
        TestConsole
    }
}
