package Test;

import Game.InterfaceController;
import Game.Language;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the Language class
 * <p>
 * Bugs: none known
 *
 * @author Rasmus Blichfeldt (tror jeg)
 * @version v.0.1
 */


public class LanguageTest {

    @Test
    public void setLanguageEnglish1() throws Exception {
        //The string we expect to be returned
        String expectedTest1 = "What is Player";
        String expectedTest2 = "landed on";
        String expectedTest3 = "Do you want to pay";


        //We set the language to "english" to see if it will give the right return value.        .
        Language.setLanguage("english");
        //We test to see if it returns the string "What is Player"
        String actualTest1 = Language.getString("name1");
        String actualTest2 = Language.getString("landed");
        String actualTest3 = Language.getString("paytax1");

        assertNotNull(actualTest1);
        assertNotNull(actualTest2);
        assertNotNull(actualTest3);
        assertEquals(expectedTest1, actualTest1);
        assertEquals(expectedTest2, actualTest2);
        assertEquals(expectedTest3, actualTest3);
    }

    @Test
    public void setLanguageEnglish2() throws Exception {
        //The string we expect to be returned
        String expectedTest1 = "What is Player";
        String expectedTest2 = "landed on";
        String expectedTest3 = "Do you want to pay";

        //We set the language to "English" to see if it will give the right return value.        .
        Language.setLanguage("English");

        //We test to see if it returns the string "What is Player"
        String actualTest1 = Language.getString("name1");
        String actualTest2 = Language.getString("landed");
        String actualTest3 = Language.getString("paytax1");

        assertNotNull(actualTest1);
        assertNotNull(actualTest2);
        assertNotNull(actualTest3);
        assertEquals(expectedTest1, actualTest1);
        assertEquals(expectedTest2, actualTest2);
        assertEquals(expectedTest3, actualTest3);
    }

    @Test
    public void setLanguageNull() throws Exception{
        //The string we expect to be returned
        String expected = "Invalid Language. Please select English";
        //We set the language to nothing (""), to see if it gives us the default answer
        //for a wrong selected language
        Language.setLanguage("");
        //We test to see if it returns the string "Invalid Language. Please select English"
        String actual = Language.getString("name1");

        assertEquals(expected, actual);
    }
}