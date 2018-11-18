/**
 * LeetCode 944 - Delete Columns to Make Sorted
 *
 * Stupid problem description.
 * It would be more interesting to compute the minimum # columns to remove such that
 * the remaining strings are in lexico-order.
 */
public class _944 {

    public int minDeletionSize(String[] A) {
        int cnt = 0;
        for (int j = 0; j < A[0].length(); j++) {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].charAt(j) > A[i + 1].charAt(j)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}

