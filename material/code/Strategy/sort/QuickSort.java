package sort;

/**
 *  This class provides the "quicksort" algorithm
 *  to sort an array of comparable objects.
 */

public class QuickSort implements SortIF {
    /**
     *  Sort a slice of an array of comparable objects.
     *  The elements of the array are swapped among themselves
     *  until the array is sorted.
     *  @param data The array to be sorted.
     *  @param left Index of first element of the slice.
     *  @param right Index of last element of the slice.
     */
    public void sort (Comparable [] a, int l, int r) {
	if (r > l) {
	    Comparable v = a [r];
	    int i = l-1;
	    int j = r;
	    for (;;) {
		while (a [++i].compareTo (v) < 0) ;
		while (a [--j].compareTo (v) > 0) ;
		if (i >= j) break;
		swap (a, i, j);
	    }
	    swap (a, i, r);
	    sort (a, l, i-1);
	    sort (a, i+1, r);
	}	
    }
    // 
    private final void swap (Comparable [] a, int l, int r) {
	Comparable t = a [l];
	a [l] = a [r];
	a [r] = t;
    }
    /**
     *  Identification.
     *  @return A string identifying the sorting algorithm.
     */
    public String info () { return "Quicksort, v092499"; }
}
