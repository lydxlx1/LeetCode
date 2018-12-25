import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 964 - Least Operators to Express Number
 *
 * Some notes:
 * - No parentheses are allowed => sum of a list of positive/negative power of x's.
 * - # of operators = # of numbers - 1, where # of numbers is a bit more clear to compute.
 * - Start from the least significant bit to the most significant bit, and we have two choices for each non-zero
 *   powers, i.e., straightforward addition or subtraction with a borrow from the higher bit.
 * - What is the time complexity?
 *   - Assume the target number is n, and we want to compute its time complexity f(n).
 *   - We have two subproblems in the recursion, and the size of each subproblem is n / x.
 *     Remaining cost in the recursion is O(1).
 *   - By Master Theorem, when x > 2, it is clear that f(n) = O(log n).
 *   - When x = 2, looks like f(n) could be linear, but it is not.
 *     One can draw some examples first to feel the complexity.
 */
public class _964 {

    Map<Long, Long> f;
    int x;
    int inf = 1 << 29;
    long limit;

    public int leastOpsExpressTarget(int x, int target) {
        this.x = x;
        f = new HashMap<>();

        long pow = x;
        limit = (long) target * x * x;
        for (int i = 1; i < 40 && pow <= limit; i++, pow *= x) {
            f.put(pow, 0L + i);
        }
        f.put(1L, 2L); // Has to use x / x to make a one.
        f.put(0L, 0L);

        return (int) f(target, 1) - 1;
    }

    long f(long target, long pow) {
        if (target % pow != 0) {
            throw new RuntimeException("");
        }
        if (pow > limit) {
            return inf;
        }
        if (f.containsKey(target)) {
            return f.get(target);
        }

        long ans = inf;
        long r = target / pow % x;
        if (r == 0) {
            ans = Math.min(ans, f(target, pow * x));
        } else {
            ans = Math.min(ans, r * f(pow, pow) + f(target - r * pow, pow * x));
            ans = Math.min(ans, (x - r) * f(pow, pow) + f(target + (x - r) * pow, pow * x));
        }

        f.put(target, ans);
        return ans;
    }
}
