/**
 * LeetCode 696 - Count Binary Substrings
 * <p>
 * O(n)-time/space DP solution (but ugly...)
 * The idea here is to count the number of CONSECUTIVE ones/zeros to the left/right at any index-i.
 */
public class _696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[][] f = new int[n][2];
        int[][] g = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                f[i][0] = 1 + (i - 1 >= 0 ? f[i - 1][0] : 0);
            } else {
                f[i][1] = 1 + (i - 1 >= 0 ? f[i - 1][1] : 0);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                g[i][0] = 1 + (i + 1 < n ? g[i + 1][0] : 0);
            } else {
                g[i][1] = 1 + (i + 1 < n ? g[i + 1][1] : 0);
            }

        }
        long ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            ans += Math.min(f[i][0], g[i + 1][1]);
            ans += Math.min(f[i][1], g[i + 1][0]);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        _696 sol = new _696();
        System.out.println(sol.countBinarySubstrings("00110011"));
        System.out.println(sol.countBinarySubstrings("10101"));
    }
}