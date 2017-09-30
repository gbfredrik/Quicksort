public class QSortTooSlow {

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
		if (high <= low + m) {
			insertionsort(a, low, high);
			return;
		}
		int j = partitition(a, low, high);
		quicksort(a, low, j - 1, m);
		quicksort(a, j + 1, high, m);
	}

	private static int partitition(int[] a, int low, int high) {
		int pivotIndex = median(a, low, (low + high) / 2, high);
		int pivot = a[pivotIndex];
		swap(a, pivotIndex, high);
		int tempL = low;
		pivotIndex = high;

		//      int tempH = high - 1;
		//		while (true) {
		//			while (a[++tempL] < pivot) {
		//			}
		//			while (a[--tempH] > pivot) {
		//			}
		//			if (tempL >= tempH) {
		//				break;
		//			}
		//			swap(a, tempL, tempH);
		//		}

		for (int i = low; i <= (high - 1); i++) {
			if (a[i] < pivot) {
				swap(a, i, tempL);
				tempL++;
			}
		}
		swap(a, pivotIndex, tempL);
		return tempL;
	}

	private static int median(int[] a, int low, int middle, int high) {
		if (a[low] > a[middle]) {
			if (a[high] > a[low]) {
				return low;
			} else if (a[high] < a[middle]) {
				return middle;
			} else
				return high;
		} else {
			if (a[high] > a[middle]) {
				return middle;
			} else if (a[high] < a[low]) {
				return low;
			} else
				return high;
		}
	}

	private static void swap(int[] a, int l, int h) {
		int tempL = a[l];
		a[l] = a[h];
		a[h] = tempL;
	}

	/**
	 * Sort from a[low] to a[high] using insertion sort.
	 */
	private static void insertionsort(int[] a, int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			int temp = a[i];
			int j = i;
			while (j > low && temp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}
}