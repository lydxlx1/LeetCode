/**
 * LeetCode 477 - Total Hamming Distance
 * <p>
 * Bit-by-bit Counting
 */
public class _477 {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = 0, b = 0;
            for (int num : nums)
                if (((1 << i) & num) == 0) a++;
                else b++;
            ans += a * b;
        }
        return ans;
    }
}