/**
 * LeetCode 845 - Longest Mountain in Array
 */
public class _845 {

    public int longestMountain(int[] A) {
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                int left = i, right = i;
                while (left - 1 >= 0 && A[left - 1] < A[left]) {
                    left--;
                }
                while (right + 1 < A.length && A[right + 1] < A[right]) {
                    right++;
                }
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}

