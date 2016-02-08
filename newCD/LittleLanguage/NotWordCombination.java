/**
 * Instances of this class represent an NotWordCombination non-terminal
 * token. 
 */
class NotWordCombination extends Combination {
    private String word;

    /**
     * constructor
     * @param word The word that this combination requires in a string
     */
    NotWordCombination(String word) {
        this.word = word;
    } // constructor(String)

    /**
     * If the given string contains the word that this NotWordCombination
     * object requires, this method returns an array of the offsets where
     * the word occurs in the string.  Otherwise, this method returns
     * null. 
     * @param s The string that this method will search for the word it
     *          requires.
     */
    int[] contains(String s) {
        if (s.indexOf(word) >= 0)
          return null;
        return new int[0];
    } // contains(String)
} // class NotWordCombination
