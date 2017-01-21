import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 491 - Increasing Subsequences
 * <p>
 * Brute-force
 */
public class _491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            if (Integer.bitCount(mask) < 2) continue;
            List<Integer> list = new ArrayList<>(Integer.bitCount(mask));
            boolean increasing = true;
            for (int i = 0; i < nums.length; i++)
                if (((1 << i) & mask) != 0) {
                    list.add(nums[i]);
                    int m = list.size();
                    if (m >= 2 && list.get(m - 2) > list.get(m - 1)) {
                        increasing = false;
                        break;
                    }
                }
            if (increasing) set.add(list);
        }
        return new ArrayList<>(set);
    }
}
