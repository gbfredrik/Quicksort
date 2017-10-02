public class QSort {
  
	/**
	 * Quicksort the array a[] using m as cutoff to insertion sort.
	 */
	public static void quicksort(int[] a, int m) {
		quicksort(a, 0, a.length - 1, m);
	}

	/**
	 * Quicksort the subarray a[low .. high].
	 * Uses median-of-three partitioning
	 * and a cutoff to insertion sort of m.
	 */
	private static void quicksort(int[] a, int low, int high, int m) {
		if (high - low <= m) {
			insertionsort(a, low, high);
		} else {
			int k = partition(a, low, high); // Partitionera. k kommer vara första positionen i den högra arrayen
			
			quicksort(a, low, k-1, m); // Sortera vänstra partitionen
			quicksort(a, k+1, high, m); // Sortera högra partitionen
		}
	}

	private static int partition(int[] a, int low, int high) {
		int pivotindex = findPivotIndex(low, high); // Hämta pivot
		int pivot = a[pivotindex];
		int temphigh = high - 1;
		
		swap(a, pivotindex, high); // Swappa pivotelementet och high

		while (low <= temphigh) { // Move bounds inward until they meet
			while (a[low] < pivot) low++;
			while ((temphigh >= low) && (a[temphigh] >= pivot)) temphigh--;
			if (temphigh > low) swap(a, low, temphigh); // Swap out-of-place values
		}

		swap(a, low, high); // Swappa tillbaks pivotelementet på rätt plats. 

		return low; // Return first position in right partition
	}

	private static int findPivotIndex(int low, int high) { 
		return (low+high)/2; // Tar mittersta elementet som pivot. 
	}

	/**
	 * Sort from a[low] to a[high] using insertion sort.
	 */
	private static void insertionsort(int[] a, int low, int high) {

		for (int i = low + 1; i <= high; i++) // Gå igenom alla element
			for (int j=i; (j>low) && (a[j] < (a[j-1])); j--) // Om elementet till vänster är högre, gör en swap.
				swap(a, j, j-1);
	}

	private static void swap(int[] a, int i, int j) { // Swap
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
