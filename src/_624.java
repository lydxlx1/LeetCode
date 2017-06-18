/**
 * LeetCode 624 - Maximum Distance in Arrays
 * <p>
 * Maintain the largest two element in the union of all arrays.
 */
public class _624 {
    public int maxDistance(int[][] arrays) {
        int maxDiff = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int[] a : arrays) {
            int last = a[a.length - 1];
            if (last > largest) {
                secondLargest = largest;
                largest = last;
            } else if (last > secondLargest) {
                secondLargest = last;
            }
        }
        for (int[] a : arrays) {
            int begin = a[0], end = a[a.length - 1];
            int diff;
            if (end == largest)
                diff = secondLargest - begin;
            else
                diff = largest - begin;
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}
