/**
 * Instances of this class represent an OrCombination non-terminal
 * token. 
 */
class OrCombination extends Combination {
    private Combination leftChild, rightChild;

    /**
     * constructor
     * @param left This object's left child.
     * @param right This object's right child.
     */
    OrCombination(Combination left, Combination right) {
        leftChild = left;
        rightChild = right;
    } // constructor(Combination, Combination)

    /**
     * If the some of the words in the given string are the words that
     * either of this Combination's object's children require, this
     * method returns an array of the offsets of the words in the
     * string.  If all of the words in the given string are the words
     * required by one of this object's children, then this method
     * returns an empty array of ints.  Otherwise, this method returns
     * null.
     * @param s The string that this method will search for the words it
     *          requires.
     */
    int[] contains(String s) {
        int[] leftResult = leftChild.contains(s);
        int[] rightResult = rightChild.contains(s);
        if (leftResult == null)
          return rightResult;
        if (rightResult == null)
          return leftResult;
        if (leftResult.length == 0)
          return leftResult;
        if (rightResult.length == 0)
          return rightResult;
        // create array of combined results
        int[] myResult;
        myResult = new int[leftResult.length + rightResult.length];
        System.arraycopy(leftResult, 0, myResult, 0, leftResult.length);
        System.arraycopy(rightResult, 0, myResult, leftResult.length,
                         rightResult.length);
        return myResult;
    } // contains(String)
} // class OrCombination
