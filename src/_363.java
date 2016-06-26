import java.util.Arrays;
import java.util.TreeMap;

/**
 * LeetCode 363 - Max Sum of Rectangle No Larger Than K
 * <p>
 * Two pointers + BST
 */
public class _363 {
    public int maxSumSubmatrix(int[][] a, int t) {
        if (a.length > a[0].length) { // transpose
            int[][] b = new int[a[0].length][a.length];
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[i].length; j++)
                    b[j][i] = a[i][j];
            return maxSumSubmatrix(b, t);
        }

        int ans = Integer.MIN_VALUE;
        int[] sum = new int[a[0].length];
        int[] prefix = new int[a[0].length];
        for (int i = 0; i < a.length; i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j < a.length; j++) {
                TreeMap<Integer, Integer> map = new TreeMap<>();
                Arrays.fill(prefix, 0);
                for (int k = 0; k < a[j].length; k++) {
                    sum[k] += a[j][k];
                    prefix[k] = (k > 0 ? prefix[k - 1] : 0) + sum[k];
                    map.putIfAbsent(prefix[k], 0);
                    map.put(prefix[k], map.get(prefix[k]) + 1);
                }
                for (int k = 0; k < a[j].length; k++) {
                    Integer floor = map.floorKey(prefix[k] + t - sum[k]);
                    if (floor != null)
                        ans = Math.max(ans, floor - prefix[k] + sum[k]);
                    map.put(prefix[k], map.get(prefix[k]) - 1);
                    if (map.get(prefix[k]) == 0) map.remove(prefix[k]);
                }
            }
        }
        return ans;
    }
}