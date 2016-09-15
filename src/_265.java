/**
 * LeetCode 265 - Paint House II
 * <p>
 * O(nk) DP
 * <p>
 * A O(nk^2) DP is straightforward. Basically, we can use f[i][j] to represent state and use O(k) for state transition,
 * where f[i][j] means the min cost to paint houses [i .. n) where the i-th house is painted by color j.
 * <p>
 * To remove the factor-k, we can only save the min element and the second min element (as well as the corresponding
 * color) of f[i][.]. When painting the i-th house by color j, we choose min[i+1] or second min[i+1] depending on
 * whether there is a color conflict.
 */
public class _265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        int[] min = new int[n + 1], minColor = new int[n + 1];
        int[] secondMin = new int[n + 1], secondMinColor = new int[n + 1];
        minColor[n] = secondMinColor[n] = -1;

        for (int i = n - 1; i >= 0; i--) {
            min[i] = secondMin[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int val = costs[i][j] + (j != minColor[i + 1] ? min[i + 1] : secondMin[i + 1]);
                if (val < min[i]) {
                    secondMin[i] = min[i];
                    secondMinColor[i] = minColor[i];
                    min[i] = val;
                    minColor[i] = j;
                } else if (val < secondMin[i]) {
                    secondMin[i] = val;
                    secondMinColor[i] = j;
                }
            }
        }
        return min[0];
    }
}