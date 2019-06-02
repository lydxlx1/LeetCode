import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode 1074 - Number of Submatrices That Sum to Target
 */
public class _1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < r; i++) {
            int[] sum = new int[c];
            for (int j = i; j < r; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int rollingSum = 0;

                for (int k = 0; k < c; k++) {
                    sum[k] += matrix[j][k];

                    rollingSum += sum[k];
                    ans += map.getOrDefault(rollingSum - target, 0);
                    map.put(rollingSum, map.getOrDefault(rollingSum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
