package Game;

import java.util.ResourceBundle;


/**
 * Fetches the selected language
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt
 * @version v.0.2
 */
public class Language {

    private static String string;
    private static String languageSelected;
    private static ResourceBundle language;


    private Language() {
    }

    public static void setLanguage(String selectLanguage) {
        languageSelected = selectLanguage;
    }

    public static String getString(String inputString) {

        // Selects the language through the String variable "inputString"
        switch (languageSelected) {
            case "english":
                language = ResourceBundle.getBundle("Language");
                break;
            case "English":
                language = ResourceBundle.getBundle("Language");
                break;
            default:
                string = "Invalid Language. Please select English";
        }

        // If an available language is not selected
        if(string == "Invalid Language. Please select English"){

            return string;
        }  else {

            // Returns the string in the selected language
            string = language.getString(inputString);

            return string;
        }


    }


}
