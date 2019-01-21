/**
 * LeetCode 977 - Squares of a Sorted Array
 *
 * O(n)-time/space solution
 */
public class _977_1 {

    public int[] sortedSquares(int[] A) {
        int[] res = A.clone();
        for (int i = 0, j = A.length - 1, k = res.length - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                res[k--] = A[i] * A[i];
                i++;
            } else {
                res[k--] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}

