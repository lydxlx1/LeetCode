import java.util.Arrays;

/**
 * LeetCode 923 - 3Sum with Multiplicity
 *
 * Two-pointer approach
 */
public class _923_1 {

    public int threeSumMulti(int[] A, int target) {
        long res = 0;

        Arrays.sort(A);
        // Enumerate the smallest and the second smallest pointers.
        // Maintain the largest pointer.
        for (int i = 0; i < A.length; i++) {
            int cnt = 0;
            for (int j = i + 1, k = A.length - 1; j < k; ) {
                if (cnt == 0) {
                    for (int kk = k; kk >= 0 && A[kk] == A[k]; kk--) {
                        cnt++;
                    }
                }

                if (A[i] + A[j] + A[k] == target) {
                    res += Math.min(cnt, k - j);
                    j++;
                } else if (A[i] + A[j] + A[k] > target) {
                    k -= cnt;
                    cnt = 0;
                } else {
                    j++;
                }
            }
        }

        return (int) (res % 1000000007);
    }
}

