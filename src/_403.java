import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 403 - Frog Jump
 * <p>
 * DP
 * f[i][j] determines whether the following state is valid:
 * the frog is currently sitting on stone i and its next jump can be j - 1, j, j + 1.
 */
public class _403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        boolean[][] f = new boolean[stones.length][stones.length + 10];
        f[0][0] = true;
        for (int i = 0; i < stones.length - 1; i++)
            for (int j = 0; j < i + 1; j++)
                if (f[i][j]) {
                    if (j - 1 > 0 && map.containsKey(stones[i] + j - 1)) f[map.get(stones[i] + j - 1)][j - 1] = true;
                    if (j > 0 && map.containsKey(stones[i] + j)) f[map.get(stones[i] + j)][j] = true;
                    if (j + 1 > 0 && map.containsKey(stones[i] + j + 1)) f[map.get(stones[i] + j + 1)][j + 1] = true;
                }
        for (int i = 0; i < f[0].length; i++)
            if (f[stones.length - 1][i]) return true;
        return false;
    }
}