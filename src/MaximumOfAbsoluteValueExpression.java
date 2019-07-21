/**
 * Maximum of Absolute Value Expression
 *
 * Interesting math problem
 *
 * Break the absolute functions by enumerating all possibilities and then do DP.
 */
public class MaximumOfAbsoluteValueExpression {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        int inf = 1 << 28;
        int a = -inf, b = -inf, c = -inf, d = -inf;
        for (int i = 0; i < arr1.length; i++) {
            ans = Math.max(ans, a + arr1[i] + arr2[i] + i);
            ans = Math.max(ans, b + arr1[i] - arr2[i] + i);
            ans = Math.max(ans, c - arr1[i] + arr2[i] + i);
            ans = Math.max(ans, d - arr1[i] - arr2[i] + i);

            a = Math.max(a, -arr1[i] - arr2[i] - i);
            b = Math.max(b, -arr1[i] + arr2[i] - i);
            c = Math.max(c, +arr1[i] - arr2[i] - i);
            d = Math.max(d, +arr1[i] + arr2[i] - i);
        }
        return ans;
    }
}


