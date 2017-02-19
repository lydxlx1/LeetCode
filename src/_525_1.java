import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525 - Contiguous Array
 * <p>
 * Divide-and-conquer method
 */
public class _525_1 {
    public int findMaxLength(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] a, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = mid, one = 0, zero = 0; i >= l; i--) {
            if (a[i] == 0) zero++;
            else one++;
            map.put(zero - one, zero + one);
        }
        int max = 0;
        for (int i = mid + 1, one = 0, zero = 0; i <= r; i++) {
            if (a[i] == 0) zero++;
            else one++;
            if (map.containsKey(one - zero)) max = Math.max(max, map.get(one - zero) + zero + one);
        }

        return Math.max(max, Math.max(dfs(a, l, mid), dfs(a, mid + 1, r)));
    }
}


