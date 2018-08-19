import java.util.Arrays;

/**
 * LeetCode 891 - Sum of Subsequences Widths
 *
 * First, we show why sorting does not change the answer.
 * - When we fix a particular subsequence, its max and min values do not change w.r.t. any of its permutation.
 *   - As a takeway, the same trick applies to any objective function that is insensitive to ordering.
 *   - Ex: sum, prod, average, mean, min-gap.
 * - Now, consider the original array A and its sorted version A'. Let n denote |A|.
 *   Let P(A) be the set containing all non-empty sub-sequences of A. Clearly, |P(A)| = 2^n - 1.
 *   Similarly, we define P(A') and |P(A')| = 2^n - 1.
 * - To show the answer of A and A' are the same, it suffices to find a bi-jection between P(A) and P(A'), which clearly exists.
 *
 *
 * Now, let's just assume A is sorted. Then, we have
 *
 * ans = sum(max(S) - min(S)), for every non-empty subsequence S of A.
 *     = sum(max(S)) - sum(min(S)), for every non-empty subsequence S of A.
 *
 * Let F(A) = sum(max(S)) and G(A) = sum(min(G)). Then, ans = F(A) - G(A).
 *
 * Since F(A) and G(A) are symmetric, we only discuss how to compute the former.
 * Let f[i] denote the # of sub-sequence ending at A[i]. Then every such sub-sequence contributes A[i] to F(A).
 * Therefore, F(A) = sum(f[i] * A[i]), 0 <= i < n.
 *
 * Finally, f[i] is equal to 2^i, as A is sorted. (Note, index-i starts from 0).
 */
public class _891 {

    public int sumSubseqWidths(int[] A) {
        int mod = 1000000007;
        long ans = 0;

        Arrays.sort(A);
        for (int i = 0, pow = 1; i < A.length; i++, pow = pow * 2 % mod) {
            ans += A[i] * pow % mod;
            ans %= mod;
        }
        for (int i = A.length - 1, pow = 1; i >= 0; i--, pow = pow * 2 % mod) {
            ans += mod - A[i] * pow % mod;
            ans %= mod;
        }

        return (int) (ans % mod);
    }
}

