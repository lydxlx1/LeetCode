/**
 * LeetCode 487 - Max Consecutive Ones II
 *
 * O(1)-space solution
 */
public class _487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, oneBeforeZero = 0, oneAfterZero = 0, zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
                if (zeroCnt > 1) {
                    zeroCnt = 1;
                    oneBeforeZero = oneAfterZero;
                    oneAfterZero = 0;
                }
            } else {
                if (zeroCnt == 0) oneBeforeZero++;
                else oneAfterZero++;
            }
            ans = Math.max(ans, oneBeforeZero + oneAfterZero + zeroCnt);
        }
        return ans;
    }
}

