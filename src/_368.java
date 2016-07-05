import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 368 - Largest Divisible Subset
 *
 * DP
 */
public class _368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return Arrays.asList();

        Arrays.sort(nums);
        int[] f = new int[nums.length], pre = new int[nums.length];
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++)
                if (nums[i] % nums[j] == 0)
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        pre[i] = j;
                    }
            if (f[i] > f[max]) max = i;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[max]);
        while (pre[max] != max) {
            max = pre[max];
            ans.add(nums[max]);
        }
        return ans;
    }

}