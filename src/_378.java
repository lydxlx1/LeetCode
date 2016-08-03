/**
 * LeetCode 378 - Kth Smallest Element in a Sorted Matrix
 *
 * Bisect + Young Tableau
 * O(n * 32) = O(n)
 */
public class _378 {

    // return # of elements in a that are <= x
    private int rank(int[][] a, long x) {
        int rank = 0;
        int i = a.length - 1, j = 0;
        while (i >= 0 && j < a[0].length) {
            if (a[i][j] <= x) {
                rank += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return rank;
    }

    public int kthSmallest(int[][] matrix, int k) {
        long left = Integer.MIN_VALUE;
        long right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (rank(matrix, mid) >= k) right = mid;
            else left = mid;
        }
        return (int) right;
    }
}
