/**
 * LeetCode 395 - Longest Substring with At Least K Repeating Characters
 * <p>
 * O(256n) solution with pruning
 *
 * We can prune the sub-problem [i, j] if j - i + 1 is no larger than the current max length.
 */
public class _395_1 {
    int[][] prefixSum;
    char[] a;
    int T, globalAns;

    private void dfs(int l, int r) {
        boolean allGood = true;
        boolean[] isBad = new boolean[26];
        for (int i = 0; i < 26; i++) {
            int cnt = prefixSum[r][i] - (l > 0 ? prefixSum[l - 1][i] : 0);
            isBad[i] = cnt > 0 && cnt < T;
            allGood = allGood && !isBad[i];
        }
        if (allGood) globalAns = Math.max(globalAns, r - l + 1);
        else {
            for (int i = l, j = -1; i <= r; i = j) {
                while (i <= r && isBad[a[i] - 'a']) i++;
                for (j = i; j <= r && !isBad[a[j] - 'a']; j++) ;
                if (i < j && j - i > globalAns) dfs(i, j - 1);
            }
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
        globalAns = 0;
        dfs(0, a.length - 1);
        return globalAns;
    }
}