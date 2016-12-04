/**
 * LeetCode 467 - Unique Substrings in Wraparound String
 * <p>
 * The final answer is at most 26 * n. Therefore, we can count them one by one.
 * <p>
 * We can uniquely represent each valid substring as a pair (firstLetter, length).
 * Break string p into several MAXIMAL valid substrings, and use those to general all valid substrings.
 * <p>
 * Note that a valid substring (firstLetter, length) can produce two more smaller ones:
 * (firstLetter, length - 1) and (firstLetter + 1, length - 1).
 */
public class _467 {
    public int findSubstringInWraproundString(String p) {
        int cnt = 0;
        boolean[][] visited = new boolean[p.length() + 1][26];
        for (int i = 0, j = 0; i < p.length(); ) {
            for (j = i + 1; j < p.length(); ) {
                int previous = p.charAt(j - 1) - 'a';
                int current = p.charAt(j) - 'a';
                if ((previous + 1) % 26 == current) j++;
                else break;
            }
            visited[j - i][p.charAt(i) - 'a'] = true;
            i = j;
        }

        for (int len = p.length(); len >= 1; len--)
            for (int i = 0; i < 26; i++)
                if (visited[len][i]) {
                    cnt++;
                    visited[len - 1][i] = visited[len - 1][(i + 1) % 26] = true;
                }

        return cnt;
    }
}