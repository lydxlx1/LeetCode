/**
 * LeetCode 915 - Partition Array into Disjoint Intervals
 */
public class _915 {

    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] min = new int[n];

        min[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], A[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(max, A[i]);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        throw new RuntimeException("");
    }
}

