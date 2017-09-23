public class QSort {

	/**
	 * Quicksort the array a[] using m as cutoff to insertion sort.
	 */
	public static void quicksort(int[] a, int m) {
		quicksort(a, 0, a.length - 1, m);
	}

	/**
	 * Quicksort the subarray a[low .. high]. Uses median-of-three partitioning
	 * and a cutoff to insertion sort of m.
	 */
	private static void quicksort(int[] a, int low, int high, int m) {
		if (high < low + m) {
			insertionsort(a, low, high);
			return;
		}
		int j = partitition(a, low, high);
		quicksort(a, low, j - 1, m);
		quicksort(a, j + 1, high, m);
	} // dummy code

	// http://www.ida.liu.se/opendsa/OpenDSA/Books/TDDC91F17/html/Quicksort.html#QuicksortPivotPRO
	private static int partitition(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		while (low < high) {
			while (a[low] < pivot) {
				low++;
			}
			while ((high >= low) && a[high] >= pivot) {
				high--;
			}
			if (high > low) {
				int c = low;
				low = high;
				high = c;
			}
		}
		return low;
	}

	/**
	 * Sort from a[low] to a[high] using insertion sort.
	 */
	private static void insertionsort(int[] a, int low, int high) {
		for (int i = low; i < high; i++) {
			for (int j = i; j > (low + 1) && a[j] < a[j - 1]; j--) {
				int c = a[j];
				a[j] = a[j - 1];
				a[j - 1] = c;
			}
		}
	} // dummy code

	private static void swap(int a, int b) {
		int c = b;
		b = a;
		a = c;
	}
}
// http://www.ida.liu.se/~TDDC91/info/misc/labbar17.pdf#page=15