/**
 * LeetCode 633 - Sum of Square Numbers
 * <p>
 * Just be careful of integer overflows
 */
public class _633 {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; (long) i * i <= c; i++)
            if (isSquare(c - i * i))
                return true;
        return false;
    }

    private boolean isSquare(int x) {
        long sqrt = (long) Math.sqrt(x);
        return sqrt * sqrt == x || (sqrt - 1) * (sqrt - 1) == x || (sqrt + 1) * (sqrt + 1) == x;
    }
}