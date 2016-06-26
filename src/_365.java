/**
 * LeetCode 365 - Water and Jug Problem
 * <p>
 * Math
 * <p>
 * Be care to the case where x, y, or z is equal to zero.
 * Also pay attention to the statement "one or both buckets by the end".
 */
public class _365 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (x == 0) return y == z;
        if (y == 0) return x == z;
        return (long) x + y >= z && z % gcd(x, y) == 0;
    }
}