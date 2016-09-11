import java.util.Random;

/**
 * LeetCode 398 - Random Pick Index
 * <p>
 * O(1) build time
 * O(n) expected query time using random sampling
 * It turns out that the expected runtime of this method is even faster than reservoir sampling.
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