import java.util.Random;

/**
 * LeetCode 384 - Shuffle an Array
 */
public class _384 {

    int[] a;
    int[] b;
    Random rand = new Random();

    public _384(int[] nums) {
        a = nums.clone();
        b = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        for (int i = 0; i < a.length; i++) b[i] = a[i];
        return b;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < b.length; i++) {
            int pos = rand.nextInt(i + 1);
            int tmp = b[i];
            b[i] = b[pos];
            b[pos] = tmp;
        }
        return b;
    }
}
