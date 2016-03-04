/**
 * This class is the superclass of all classes whose instances can be
 * part of a parse tree.
 */
abstract class Combination {
    /**
     * If the given string contains the words that this Combination
     * object requires, this method returns an array of ints.  In most
     * cases, the array contains the offsets of the words in the string
     * that are required by this combination.  However, if the array is
     * empty, then all the words in the string satisfy the combination.
     * If the given string does not contain the words that this
     * Combination object requires, then this method returns null.
     * @param s The string that this method will search for the words it
     *          requires.
     */
    abstract int[] contains(String s) ;
} // class Combination
