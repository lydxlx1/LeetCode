/**
 * LeetCode 371 - Sum of Two Integers
 *
 * Bit Manipulation
 *
 * Elegant step: (a & b) << 1 computes all the carries.
 */
public class _371 {
    public int getSum(int a, int b) {
        int withoutCarry = a ^ b;
        int carry = a & b;
        return carry == 0 ? withoutCarry : getSum(withoutCarry, carry << 1);
    }
}
