import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 139 - Word Break
 * <p>
 * Trie + DP
 */
public class _139_1 {

    static class Trie {
        boolean isString;
        Trie[] children = new Trie[26];
    }

    private void build(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.children[ch] == null) root.children[ch] = new Trie();
            root = root.children[ch];
        }
        root.isString = true;
    }

    Map<String, Boolean> map;
    Trie root;

    private boolean dfs(String s) {
        if (map.containsKey(s)) return map.get(s);
        boolean res = false;

        Trie u = root;
        for (int i = 0; i < s.length(); i++) {
            u = u.children[s.charAt(i) - 'a'];
            if (u != null && u.isString && dfs(s.substring(i + 1))) { // Here is i + 1
                res = true;
                break;
            } else if (u == null) break;
            else continue; // Prevent hanging-else
        }

        map.put(s, res);
        return res;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        root = new Trie();
        root.isString = true;
        for (String str : wordDict) build(root, str);
        map = new HashMap<>();
        map.put("", true);
        return dfs(s);
    }
}
