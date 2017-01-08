/**
 * LeetCode 476 - Number Complement
 *
 * Bit manipulation
 */
public class _476 {
    public int findComplement(int num) {
        return num ^ (Integer.highestOneBit(num) | Integer.highestOneBit(num) - 1);
    }
}