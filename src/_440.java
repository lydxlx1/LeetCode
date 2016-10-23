/**
 * LeetCode 440 - Kth Smallest in Lexicographical Order
 * <p>
 * Counting + Greedy
 */
public class _440 {
    private int countPrefix(int prefix, int n) {
        int ans = 0, pow10 = 1, lower = ("" + prefix).length(), upper = ("" + n).length();
        for (int len = lower; len <= upper; len++) {
            if (prefix < n / pow10) ans += pow10;
            else ans += Math.max(0, n - prefix * pow10 + 1);

            pow10 *= 10;
        }
        return ans;
    }

    public int findKthNumber(int n, int k) {
        int ans = 0;
        while (k > 0) {
            for (int i = 0; i < 10; i++) {
                if (i == 0 && ans == 0) continue;
                int cnt = countPrefix(ans * 10 + i, n);
                if (k > cnt) k -= cnt;
                else {
                    k--;
                    ans = ans * 10 + i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _440 sol = new _440();
        int n = 100;
        for (int i = 1; i <= n; i++) System.out.println(sol.findKthNumber(n, i));
    }
}