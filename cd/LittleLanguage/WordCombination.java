/**
 * Instances of this class represent an Wordcombination non-terminal
 * token. 
 */
class WordCombination extends Combination {
    private String word;

    /**
     * constructor
     * @param word The word that this combination requires in a string
     */
    WordCombination(String word) {
        this.word = word;
    } // constructor(String)

    /**
     * If the given string contains the word that this WordCombination
     * object requires, this method returns an array of the offsets where
     * the word occurs in the string.  Otherwise, this method returns
     * null. 
     * @param s The string that this method will search for the word it
     *          requires.
     */
    int[] contains(String s) {
        int indexCount = 0;     // Number of occurrences found so far.
        int[] array = new int[16];// collect offsets in this array
        int index = s.indexOf(word); // The offset to start searching for the
                                // next occurrence.
        while (index >= 0) {
            // ensure array is large enough
            if (indexCount >= array.length) {
                int[] largerArray = new int[array.length*2];
                System.arraycopy(array, 0, largerArray, 0, indexCount);
                array = largerArray;
            } // if
            index = s.indexOf(word, index);
            array[indexCount] = index;
            indexCount++;
        } // while
        if (indexCount == 0)
          return null;
        if (indexCount == array.length)
          return array;
        int[] finishedArray = new int[array.length];
        System.arraycopy(array, 0, finishedArray, 0, array.length);
        return finishedArray;
    } // contains(String)
} // class Wordcombination
