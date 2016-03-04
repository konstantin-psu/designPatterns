/**
 * Instances of this class represent an AndCombination non-terminal
 * token. 
 */
class AndCombination extends Combination {
    private Combination leftChild, rightChild;

    /**
     * constructor
     * @param left This object's left child.
     * @param right This object's right child.
     */
    AndCombination(Combination left, Combination right) {
        leftChild = left;
        rightChild = right;
    } // constructor(Combination, Combination)

    /**
     * This method returns an array of the offsets of the words in the
     * given string that satify both of this AndCombination object's
     * children.  However, if all the words in the given string satisfy
     * both of this object's children, it returns an empty array.
     * Otherwise, this method returns null. 
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

        // Sort the results so that they can be compared and merged
        Sorter.sort(leftResult);
        Sorter.sort(rightResult);

        // Count common offsets to find out if there are common offsets
        // and how many there will be.
        int commonCount = 0;
        for (int l=0,r=0; l<leftResult.length && r<rightResult.length;){
            if (leftResult[l] < rightResult[r]) {
                l++;
            } else if (leftResult[l] > rightResult[r]) {
                r++;
            } else {
                commonCount++;
                l++;
                r++;
            } // if
        } // for
        if (commonCount == 0)
          return null;          // There are no common results

        // merge common results
        int[] myResult = new int[commonCount];
        commonCount = 0;
        for (int l=0,r=0; l<leftResult.length && r<rightResult.length;){
            if (leftResult[l] < rightResult[r]) {
                l++;
            } else if (leftResult[l] > rightResult[r]) {
                r++;
            } else {
                myResult[commonCount] = leftResult[l];
                commonCount++;
                l++;
                r++;
            } // if
        } // for
        return myResult;
    } // contains(String)
} // class AndCombination
