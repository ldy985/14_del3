package Game;

import java.util.ResourceBundle;


/**
 * Fetches the selected language
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt
 * @version v.0.1
 */
public class Language {

    private static String string;
    private static String languageSelected;
    private static ResourceBundle language;

    public static void setLanguage(String selectLanguage) {
        languageSelected = selectLanguage;
    }

    public static String getString(String inputString) {

        // Selects the language through the String variable "inputString"
        switch (languageSelected) {
            case "english":
                language = ResourceBundle.getBundle("Language");
                break;
            default:
                string = "Invalid Language. Please select English";
        }

        // Returns the selected language
        string = language.getString(inputString);

        return string;
    }


}
