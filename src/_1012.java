/**
 * LeetCode 1015 - Numbers With Repeated Digits
 *
 * Bracktracking
 */
public class _1012 {

    public int numDupDigitsAtMostN(int N) {
        return N - dfs(N, 0, 0);
    }

    int dfs(int N, int mask, long cur) {
        if (cur > N) {
            return 0;
        }
        int cnt = cur > 0 ? 1 : 0;
        for (int i = 0; i < 10; i++) {
            if (i == 0 && cur == 0) {
                continue;
            }
            if ((mask & (1 << i)) == 0) {
                cnt += dfs(N, mask | (1 << i), cur * 10 + i);
            }
        }
        return cnt;
    }
}