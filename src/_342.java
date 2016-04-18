/**
 * LeetCode 342 - Power of Four
 *
 * Bit Manipulation
 * Basically, if a number is power of four, it is firstly a power of two, and then its only one bit can only appear at even positions.
 *
 * So, 0xAAAAAAAA is the mask of all banned positions,
 * and 0x55555555 is the mask of all feasible positions.
 */
public class _342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xAAAAAAAA) == 0;
    }
}