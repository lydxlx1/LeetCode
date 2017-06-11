import java.util.Arrays;

/**
 * LeetCode 611 - Valid Triangle Number
 * <p>
 * Three-sum related problem
 */
public class _611 {
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int k = 2; k < nums.length; k++) {
            int i = 0, j = k - 1;
            while (i < j)
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += j - i;
                    j--;
                } else {
                    i++;
                }
        }
        return cnt;
    }
}