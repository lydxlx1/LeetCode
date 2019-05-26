import java.util.Arrays;

/**
 * LeetCode 1053 - Previous Permutation With One Swap
 *
 * Math
 */
public class _1053 {

    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int j = i + 1;
                while (j + 1 < A.length && A[i] > A[j + 1]) {
                    j++;
                }
                // Thanking in terms of the example
                // Input: [3, 1, 1, 3]
                // Output: [1, 3, 1, 3]
                while (A[j - 1] == A[j]) {
                    j--;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                break;
            }
        }
        return A;
    }
}
