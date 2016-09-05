/**
 * LeetCode 395 - Longest Substring with At Least K Repeating Characters
 * <p>
 * O(256n) solution
 * <p>
 * After entering a new level, at least one kind of letter will permanently be eliminated.
 * Therefore, at most 26 levels.
 * Since all the sub-problems on the same level are disjoint, the sum of problem sizes on each level is O(n).
 * In this simple solution, we manually scan all 26 letters, increasing the runtime per level by a factor of 26.
 * Thus, the total complexity is O(26^2 n) = O(256n).
 */
public class _395 {
    int[][] prefixSum;
    char[] a;
    int T;

    private int dfs(int l, int r) {
        boolean allGood = true;
        boolean[] isBad = new boolean[26];
        for (int i = 0; i < 26; i++) {
            int cnt = prefixSum[r][i] - (l > 0 ? prefixSum[l - 1][i] : 0);
            isBad[i] = cnt > 0 && cnt < T;
            allGood = allGood && !isBad[i];
        }
        if (allGood) return r - l + 1;
        else {
            int ans = 0;
            for (int i = l, j = -1; i <= r; i = j) {
                while (i <= r && isBad[a[i] - 'a']) i++;
                for (j = i; j <= r && !isBad[a[j] - 'a']; j++) ;
                if (i < j) ans = Math.max(ans, dfs(i, j - 1));
            }
            return ans;
        }
    }

    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        T = k;
        a = s.toCharArray();
        prefixSum = new int[a.length][26];
        for (int i = 0; i < a.length; i++) {
            prefixSum[i][a[i] - 'a']++;
            if (i > 0)
                for (int j = 0; j < 26; j++)
                    prefixSum[i][j] += prefixSum[i - 1][j];
        }
        return dfs(0, a.length - 1);
    }
}