/**
 * LeetCode 338 - Counting Bits
 *
 * A simple counting problem.
 */
public class _338 {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}