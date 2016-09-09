import java.util.*;

/**
 * LeetCode 140 - Word Break II
 *
 * DP + DFS
 */
public class _140 {

    boolean[] f;
    String s;
    Set<String> wordDict;
    List<String> ans;

    private void dfs(int i, Deque<String> deque) {
        if (i >= s.length()) ans.add(String.join(" ", deque));
        else {
            String sub = null;
            for (int j = i + 1; j <= s.length(); j++)
                if (f[j] && wordDict.contains(sub = s.substring(i, j))) {
                    deque.addLast(sub);
                    dfs(j, deque);
                    deque.removeLast();
                }
        }
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        f = new boolean[s.length() + 1];
        f[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--)
            for (int j = i + 1; j <= s.length(); j++)
                if (wordDict.contains(s.substring(i, j)) && f[j]) {
                    f[i] = true;
                    break;
                }
        ans = new ArrayList<>();
        if (f[0]) dfs(0, new ArrayDeque<>());
        return ans;
    }
}