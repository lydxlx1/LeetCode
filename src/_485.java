/**
 * LeetCode 485 - Max Consecutive Ones
 */
public class _485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length; )
            if (nums[i] == 1) {
                for (j = i + 1; j < nums.length && nums[j] == 1; j++) ;
                ans = Math.max(ans, j - i);
                i = j;
            } else {
                i++;
            }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        _485 sol = new _485();
    }
}

