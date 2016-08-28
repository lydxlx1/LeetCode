/**
 * Elimination Game
 *
 * Math - O(log n)
 */
public class _390 {

    private int f(int n, int dir) {
        if (n == 1) return 1;
        if (n % 2 == 0) {
            if (dir == 0) return 2 * f(n / 2, 1 - dir);
            else return 2 * f(n / 2, 1 - dir) - 1;
        } else {
            return 2 * f(n / 2, 1 - dir);
        }
    }

    public int lastRemaining(int n) {
        return f(n, 0);
    }
}
