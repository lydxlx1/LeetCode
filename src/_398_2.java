import java.util.Random;

/**
 * LeetCode 398 - Random Pick Index
 * <p>
 * O(1) build time
 * O(n) query time using random sampling
 */
public class _398_2 {
    Random rand;
    int[] nums;

    public _398_2(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int i = rand.nextInt(nums.length);
        while (nums[i] != target) i = rand.nextInt(nums.length);
        return i;
    }
}