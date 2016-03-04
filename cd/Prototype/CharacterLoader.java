import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * This class loads character objects and adds them to the
 * the CharacterManager.
 */
class CharacterLoader {
    private CharacterManager mgr;

    /**
     * Constructor
     * @param cm The CharacterManager that this object will work with.
     */
    CharacterLoader(CharacterManager cm) {
        mgr = cm;
    } // Constructor(CharacterManager)

    /**
     * Load character objects from the specified file.
     * Since failure only affects the rest of the program to the extent
     * that new character objects are not loaded, we need not throw any
     * exceptions.
     * @param fname The name of the file to read objects from.
     * @return The number of Charcter objects loaded.
     */
    int loadCharacters(String fname) {
        int objectCount = 0;    // The number of objects loaded

        // If construction of the InputStream fails, just return
        try {
            InputStream in;
            in = new FileInputStream(fname);
            in = new BufferedInputStream(in);
            ObjectInputStream oIn = new ObjectInputStream(in);
            while(true) {
                Object c = oIn.readObject();
                if (c instanceof Character) {
                    mgr.addCharacter((Character)c);
                    objectCount++;
                } // if
            } // while
        } catch (Exception e) {
        } // try
        return objectCount;
    } // loadCharacters(String)
} // class CharacterLoader
