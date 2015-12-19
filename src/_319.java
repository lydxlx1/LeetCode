/**
 * LeetCode 319 - Bulb Switcher
 *
 * O(1) Math
 *
 * Only perfect squares remain switched on since divisors appear in pairs.
 */
public class _319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}