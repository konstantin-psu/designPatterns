/**
 * This class is a utility for sorting arrays of primitive types.
 * The algorithm used is radix sort, which sorts data in linear time.
 * @author Mark Grand
 */
public class Sorter {
    /**
     * prevent other classes from instantiating this class.
     */
    private Sorter() {}

    // During sorting this array contains the index of first array
    // element that has a byte value that correponds to the indes of the
    // element.
    private static int[] bucketHeaders = new int[256];

    // Value to indicate the end of a linked list of indices.
    private final static int END = -1;

    /**
     * Sort an array of int in place
     */
    public static void sort(int[] array) {
        // array for copying values into
        int[] copyArray = new int[array.length];

        // array to store buckets of indexes
        int[] bucketArray = new int[array.length];

        sortUnsignedByte(array, copyArray, bucketArray, 0);
        sortUnsignedByte(array, copyArray, bucketArray, 8);
        sortUnsignedByte(array, copyArray, bucketArray, 16);
        sortSignedByte(array, copyArray, bucketArray);
    } // sort(int[])

    /**
     * Sort the values in an array based on the unsigned interpretation
     * of one of their bytes.
     * @param array The array to sort.
     * @param copyArray An array to copy sorted values into.
     * @param bucketArray An array to use for storing buckets of
     *                    indices.  It must be at least as long as
     *                    array.
     * @param shift The number of bits to do an unsigned right shift
     *              in order to put the byte to sort in in the low order
     *              position.  
     */
    private static void sortUnsignedByte(int[] array,
                                  int[] copyArray,
                                  int[] bucketArray,
                                  int shift) {
        // initialize buckets to empty
        for (int i = 0; i < 256; i++) {
            bucketHeaders[i] = END;
        } // for

        // Organize array into buckets by byte value
        for (int i=array.length-1; i >= 0; i--) {
            int byt = (array[i] >>> shift) & 0xff;
            bucketArray[i] = bucketHeaders[byt];
            bucketHeaders[byt] = i;
        } // for

        // copy values for array to copyArray by bucket, starting with
        // the 0x00 bucket and ending with the 0xff bucket.
        int copyNdx = 0;
        for (int i=0; i<256; i++) {
            int next = bucketHeaders[i];
            while (next != END) {
                copyArray[copyNdx] = array[next];
                copyNdx++;
                next = bucketArray[next];
            } // while !END
        } // for i

        /**
         * copy byte sorted values back to original array
         */
        System.arraycopy(copyArray, 0, array, 0, array.length);
    } // sortUnsignedByte(int[], int[], int)

    /**
     * Sort the values in an array based on the signed interpretation
     * of one of their high order byte
     * @param array The array to sort.
     * @param copyArray An array to copy sorted values into.
     * @param bucketArray An array to use for storing buckets of
     *                    indices.  It must be at least as long as
     *                    array.
     */
    private static void sortSignedByte(int[] array,
                                       int[] copyArray,
                                       int[] bucketArray) {
        // initialize buckets to empty
        for (int i = 0; i < 256; i++) {
            bucketHeaders[i] = END;
        } // for

        // Organize array into buckets by byte value
        for (int i=array.length-1; i >= 0; i--) {
            int byt = (array[i] >> 24) + 128;
            bucketArray[i] = bucketHeaders[byt];
            bucketHeaders[byt] = i;
        } // for

        // copy values for array to copyArray by bucket, starting with
        // the 0x00 bucket and ending with the 0xff bucket.
        int copyNdx = 0;
        for (int i=0; i<256; i++) {
            int next = bucketHeaders[i];
            while (next != END) {
                copyArray[copyNdx] = array[next];
                copyNdx++;
                next = bucketArray[next];
            } // while !END
        } // for i

        /**
         * copy byte sorted values back to original array
         */
        System.arraycopy(copyArray, 0, array, 0, array.length);
    } // sortUnsignedByte(int[], int[], int)
} // class Sorter
