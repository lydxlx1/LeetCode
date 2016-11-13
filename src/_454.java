import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 454 - 4Sum II
 * <p>
 * O(n^2) solution using HashMap
 */
public class _454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A)
            for (int b : B)
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
        for (int c : C)
            for (int d : D)
                ans += map.getOrDefault(-c - d, 0);
        return ans;
    }
}
