import java.util.Arrays;

/**
 * LeetCode 455 - Assign Cookies
 *
 * Greedy
 */
public class _455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; )
            if (g[i] <= s[j]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        return ans;
    }
}
