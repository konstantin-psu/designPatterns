package sort;

/**
 *  This interface defines the methods that each sorting class
 *  must have.
 */

public interface SortIF {
    /**
     *  Sort a slice of an array of comparable objects.
     *  The elements of the array are swapped among themselves
     *  until the array is sorted.
     *  @param data The array to be sorted.
     *  @param left Index of first element of the slice.
     *  @param right Index of last element of the slice.
     */
    void sort (Comparable [] data, int l, int r);
    /**
     *  Identification.
     *  @return A string identifying the sorting algorithm.
     */
    String info ();
}
