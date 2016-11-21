package Test;

import Game.Language;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Language class
 *
 * Bugs: none known
 *
 * @author       Rasmus Blichfeldt (tror jeg)
 * @version      v.0.1
 */


public class LanguageTest {

    @Test
    public void setLanguage() throws Exception {
        //We set the language to english to see if it will give the right return value.
        //We can't test setLanguage because that would require ......
        Language.setLanguage("english");
        //We test to see if it shows the players name
        String i=Language.getString("name1");
        assertEquals("What is Player",i);
    }
}