import java.util.Arrays;

/**
 * LeetCode 496 - Next Greater Element I
 * <p>
 * Brute-force
 */
public class _496 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ans = new int[findNums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
            for (int j = 0; j < nums.length; j++)
                if (findNums[i] == nums[j]) {
                    for (int k = j + 1; k < nums.length; k++)
                        if (nums[k] > findNums[i]) {
                            ans[i] = nums[k];
                            break;
                        }
                    break;
                }
        }
        return ans;
    }
}
