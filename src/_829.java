/**
 * LeetCode 829 - Consecutive Numbers Sum
 * <p>
 * Math
 */
public class _829 {

    public int consecutiveNumbersSum(int N) {
        int ans = 0;

        // Enumerate # of terms in the AP and try to solve for the initial term a.
        // Then, the last term is a + (terms - 1)
        // Since we have N = (a + (a + (terms - 1)) * terms / 2, it follows that
        // 2a + terms - 1 = 2 * N / terms, and
        // a = (2 * N / terms + 1 - terms) / 2.
        // We want to make sure a is a positive integer.
        for (long terms = 1; terms * terms <= 2L * N; terms++) {
            if (2L * N % terms == 0) {
                long tmp = 2L * N / terms;
                long a = tmp + 1 - terms;
                if (a % 2 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

