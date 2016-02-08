package sort;

/**
 *  This class provides the "straight selection" algorithm
 *  to sort an array of comparable objects.
 */

public class SelectionSort implements SortIF {
    /**
     *  Sort a slice of an array of comparable objects.
     *  The elements of the array are swapped among themselves
     *  until the array is sorted.
     *  @param data The array to be sorted.
     *  @param left Index of first element of the slice.
     *  @param right Index of last element of the slice.
     */
    public void sort (Comparable [] data, int left, int right) {
	for (int firstIndex = left; firstIndex < right-1; firstIndex++) {
	    int minIndex = firstIndex;
	    Comparable minValue = data [minIndex];
	    for (int i = firstIndex; i < right; i++) {
		if (minValue.compareTo (data [i]) <= 0) continue;
		minIndex = i;
		minValue = data [i];
	    }
	    data [minIndex] = data [firstIndex];
	    data [firstIndex] = minValue;
	}
    }
    /**
     *  Identification.
     *  @return A string identifying the sorting algorithm.
     */
    public String info () { return "Selection sort, v092499"; }
}
