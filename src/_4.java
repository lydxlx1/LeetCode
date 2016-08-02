/**
 * LeetCode 4 - Median of Two Sorted Arrays
 * <p>
 * Implement a universal function to find any k-th element of the array.
 * Binary search in one array to find.
 * If not found, then the second binary search in the other array will guarantee a success.
 */
public class _4 {
    private int binarySearch(int[] a, int[] b, int k) {
        int left = 0, right = Math.min(a.length - 1, k - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            int cb = k - mid - 2 < 0 ? Integer.MIN_VALUE : k - mid - 2 >= b.length ? Integer.MAX_VALUE : b[k - mid - 2];
            int wb = k - mid - 1 < 0 ? Integer.MIN_VALUE : k - mid - 1 >= b.length ? Integer.MAX_VALUE : b[k - mid - 1];
            if (a[mid] < cb) left = mid + 1;
            else if (a[mid] == cb) return mid;
            else if (a[mid] <= wb) return mid;
            else right = mid - 1;
        }
        return -1;
    }

    private int find(int[] a, int[] b, int k) {
        int index = binarySearch(a, b, k);
        if (index >= 0) return a[index];
        else return b[binarySearch(b, a, k)];
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int size = a.length + b.length;
        if (size % 2 == 1) return find(a, b, size / 2 + 1);
        else return (0.0 + find(a, b, size / 2) + find(a, b, size / 2 + 1)) / 2;
    }
}
