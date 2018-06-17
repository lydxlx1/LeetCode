/**
 * LeetCode 852 - Peak Index in a Mountain Array
 * <p>
 * Binary Search
 */
public class _852 {

    public int peakIndexInMountainArray(int[] a) {
        int left = 1, right = a.length - 2;
        while (true) {
            int mid = (left + right) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] > a[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}

