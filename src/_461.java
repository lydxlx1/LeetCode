/**
 * LeetCode 461 - Hamming Distance
 * <p>
 * Brute-force
 */
public class _461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}