/**
 * LeetCode 1004 - Max Consecutive Ones III
 *
 * Sliding window
 * O(n)-time solution
 */
public class _1004 {

    public int longestOnes(int[] A, int K) {
        boolean[] flipped = new boolean[A.length];
        int ans = 0;
        // Enumerate left boundary i and try to push right boundary as far as possible.
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] == 0 && K > 0) {
                K--;
                flipped[i] = true;
                A[i] = 1;
            }

            j = Math.max(j, i);
            while (j < A.length) {
                if (A[j] == 0 && K > 0) {
                    K--;
                    A[j] = 1;
                    flipped[j] = true;
                }
                if (A[j] == 1) {
                    j++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, j - i);

            if (flipped[i]) {
                K++;
                A[i] = 0;
            }
        }
        return ans;
    }
}

