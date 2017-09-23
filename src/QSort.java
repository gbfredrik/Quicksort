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
        if (high <= low + m) {
            insertionsort(a, low, high);
            return;
        }
        int pivot = median(a, low, high);
        int j = partitition(a, low, high, pivot);
        quicksort(a, low, j - 1, m);
        quicksort(a, j + 1, high, m);
    }

    // http://www.ida.liu.se/opendsa/OpenDSA/Books/TDDC91F17/html/Quicksort.html#QuicksortPivotPRO
    private static int partitition(int[] a, int low, int high, int pivot) {
        int tempL = low;
        /*
        int tempH = high - 1;
        while (true) {
            while (a[++tempL] < pivot) {
            }
            while (a[--tempH] > pivot) {
            }
            if (tempL >= tempH) {
                break;
            }
            swap(a, tempL, tempH);
        }
        */
        for (int i = low; i <= (high - 1); i++) {
            if (a[i] < pivot) {
                swap(a, i, tempL);
                tempL++;
            }
        }
        swap(a, tempL, high - 1);
        return tempL;
    }

    private static int median(int[] a, int low, int high) {
        int middle = (low + high) / 2;
        if (a[low] > a[middle]) {
            swap(a, low, middle);
        }
        if (a[low] > a[high]) {
            swap(a, low, high);
        }
        if (a[middle] > a[high]) {
            swap(a, middle, high);
        }
        swap(a, middle, high - 1);
        return a[high - 1];
    }

    private static void swap(int[] a, int l, int h) {
        int tempL = a[l];
        a[l] = a[h];
        a[h] = tempL;
    }

    /**
     * Sort from a[low] to a[high] using insertion sort.
     */
    public static void insertionsort(int[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int lifted = a[i];
            int j;
            for (j = i; j > low && lifted < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = lifted;
        }
    }
}
// http://www.ida.liu.se/~TDDC91/info/misc/labbar17.pdf#page=15