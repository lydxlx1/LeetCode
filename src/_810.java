/**
 * LeetCode 810 - Chalkboard XOR Game
 * <p>
 * Game theory
 */
public class _810 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }
}
