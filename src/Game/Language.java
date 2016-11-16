package Game;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by razze on 16-11-2016.
 */
public class Language {

    private static String string;
    private static String languageSelected;
    private static ResourceBundle language;

    public static void setLanguage(String selectLanguage){ languageSelected = selectLanguage; }

    public static String getString(String inputString){

        // Selects the language through the String variable "inputString"
        switch (languageSelected){
            case "english" : language = ResourceBundle.getBundle("Language");
                break;
            default: string = "Invalid Language. Please select English";
        }

        // Returns th
        string = language.getString(inputString);

        return string;
    }


}
