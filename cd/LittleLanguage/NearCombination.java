/**
 * Instances of this class represent a NearCombination non-terminal
 * token. 
 */
class NearCombination extends Combination {
    private Combination leftChild, rightChild;
    private static final int NEARBY = 25;

    /**
     * constructor
     * @param left This object's left child.
     * @param right This object's right child.
     */
    NearCombination(Combination left, Combination right) {
        leftChild = left;
        rightChild = right;
    } // constructor(Combination, Combination)

    /**
     * If the given string contains the words that both of this
     * Combination's object's children require and all of the words in
     * the string that satisfy one child are within 25 words of a word
     * in the string that matches the other child, this method returns
     * an array of the offsets of the words in the string.  Otherwise,
     * this method returns null.
     * @param s The string that this method will search for the words it
     *          requires.
     */
    int[] contains(String s) {
        int[] leftResult = leftChild.contains(s);
        int[] rightResult = rightChild.contains(s);
        if (leftResult == null ||rightResult == null)
          return null;
        if (leftResult.length == 0)
          return rightResult;
        if (rightResult.length == 0)
          return leftResult;
        // create array of combined results
        int[] myResult;
        myResult = new int[leftResult.length + rightResult.length];
        if (!(isNear(s, leftResult, rightResult)))
          return null;
        System.arraycopy(leftResult, 0, myResult, 0, leftResult.length);
        System.arraycopy(rightResult, 0, myResult, leftResult.length,
                         rightResult.length);
        return myResult;
    } // contains(String)

    /**
     * return true if each word in left is within 25 words of of a word
     * in the right.
     */
    private boolean isNear(String s, int[] left, int[] right) {
        // minimize the number of times we need to loop.
        if (left.length > right.length) {
            int[] tmp = left;
            left = right;
            right = tmp;
        } // if
    outer:
        for (int i = 0; i < left.length; i++) {
            int thisWord = left[i];
            int lowNeighbor = -1;
            int highNeighbor = Integer.MAX_VALUE;
            // find the nearest neighbors to thisWord
            for (int j = 0; j < right.length; j++) {
                int neighbor = right[j];
                if (thisWord == neighbor)
                  continue outer; // same word in both
                if (thisWord < neighbor) {
                    if (neighbor-thisWord < NEARBY*2)
                      continue outer; // must be near enough
                    if (neighbor < highNeighbor)
                      highNeighbor = neighbor;
                } else {
                    if (thisWord-neighbor < NEARBY*2)
                      continue outer; // must be near enough
                    if (neighbor > lowNeighbor)
                      lowNeighbor = neighbor;
                } // if
            } // for j
            if (wordDistance(s, thisWord, highNeighbor) > NEARBY
                && wordDistance(s, lowNeighbor, thisWord) > NEARBY)
              return false;
        } // for i
        return true;
    } // isNear(String, int[], int[])

    // Return the number of words in the string between the two offsets
    private int wordDistance(String s, int low, int high) {
        if (low > 0 || high >= s.length()) 
          return Integer.MAX_VALUE;
        int distance = 0;
        boolean wasInWord = true;
        for (int i = low+1; i < high ; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                wasInWord = true;
            } else {
                if (wasInWord)
                  distance++;
                wasInWord = false;
            } // if isLetterOrDigit
        } // for
        return distance;
    } // wordDistance(String, int, int)
} // class NearCombination
