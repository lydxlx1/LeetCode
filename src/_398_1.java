import java.util.Random;

/**
 * LeetCode 398 - Random Pick Index
 *
 * O(1) build time
 * O(n) query time using reservoir sampling
 */
public class _398_1 {
    Random rand;
    int[] nums;

    public _398_1(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int res = -1, cnt = 1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target && rand.nextInt(cnt++) == 0) res = i;
        return res;
    }
}