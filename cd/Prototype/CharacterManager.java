import java.util.Vector;

/**
 * This class manages the collection of prototypical objects for the
 * game.  When asked to, it clones an appropriate prototypical object
 * and returns it to the requesting object.
 */
public class CharacterManager {
    private Vector characters = new Vector();
    //...

    /**
     * Return a random character from the collection.
     */
    Character getRandomCharacter() {
        int i = (int)(characters.size()*Math.random());
        return (Character)((Character)characters.elementAt(i)).clone();
        
    } // getRandomCharacter()

    /**
     * Add a prototypical object to the collection.
     * @param character The character to add.
     */
    void addCharacter(Character character) {
        characters.addElement(character);
    } // addCharacter(Character)
    //...
} // class CharacterManager
