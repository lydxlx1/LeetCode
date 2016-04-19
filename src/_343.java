/**
 * LeetCode 343 - Integer Break
 *
 * Basically try to squeeze more factors of 3.
 *
 * The math behind this problem.
 *
 * I saw many solutions were referring factors of 2 and 3. But why these two magic numbers? Why other factors do not work?
 * Let's study the math behind it.
 *
 * Say we can break a sufficiently large number n into any smaller real positive numbers, and we try to calculate which real number generates the largest product.
 * Assume we break n into (n / x) x's, then the product will be x^(n/x), and we want to maximize it.
 *
 * Taking its derivative give us n * x^{n/x-2} * (1-ln(x)).
 * The derivative is negative when 0 < x < e, and equal to 0 when x = e, then becomes positive when x > e,
 * which indicates that the product increases as x increases, then reaches its maximum when x = e, then starts dropping.
 *
 * This reveals the fact that if n is sufficient large and we are allowed to break n into real numbers,
 * the best idea to break it into nearly all e's.
 * On the other hand, if n is sufficient large and we can only break n into integers, we should choose integers that are closer to e.
 * The only potential candidates are 2 and 3 since 2 < e < 3, but we will generally prefer 3 to 2. Why?
 *
 * Of course, one can prove it based on the above formula, but there is a more natural way shown as follows.
 *
 * 6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3.
 * Therefore, if there are three 2's in the decomposition, we can replace them by two 3's to gain a larger product.
 *
 * All the analysis above assumes n is significantly large. And if n is small (say n <= 10), it may contains flaws.
 * For instance, when n = 4, we have 2 * 2 > 3 * 1.
 * To fix it, we keep breaking n into 3's until n gets smaller than 10, then solve the problem by brute-force.
 */
public class _343 {
    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        System.arraycopy(new int[]{0, 0, 1, 2, 4, 6, 9}, 0, f, 0, Math.min(7, n + 1));
        for (int i = 7; i <= n; i++) f[i] = Math.max(f[i - 2] * 2, f[i - 3] * 3);
        return f[n];
    }
}
