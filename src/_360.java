/**
 * LeetCode 360 - Sort Transformed Array
 * <p>
 * O(n)-time solution
 */
public class _360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        for (int i = 0, j = nums.length - 1, ptr = 0; i <= j; ) {
            int f1 = f(nums[i], a, b, c);
            int f2 = f(nums[j], a, b, c);
            if (a < 0) {
                // Two increasing sub-sequences
                if (f1 < f2) {
                    ans[ptr++] = f1;
                    i++;
                } else {
                    ans[ptr++] = f2;
                    j--;
                }
            } else {
                // Two decreasing sub-sequences
                if (f1 > f2) {
                    ans[ptr++] = f1;
                    i++;
                } else {
                    ans[ptr++] = f2;
                    j--;
                }
            }
        }

        // Final check to see whether ans is accidently sorted in decreasing order.
        if (ans[0] > ans[ans.length - 1])
            for (int i = 0, j = ans.length - 1; i < j; i++, j--) {
                int tmp = ans[i];
                ans[i] = ans[j];
                ans[j] = tmp;
            }

        return ans;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}