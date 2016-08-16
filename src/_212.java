import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 212 - Word Search II
 * <p>
 * DFS + Trie
 */
public class _212 {
    static class Trie {
        String str = null;
        Trie[] ch = new Trie[26];
    }

    private void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.ch[ch] == null) root.ch[ch] = new Trie();
            root = root.ch[ch];
        }
        root.str = s;
    }

    private void dfs(Trie root, char[][] a, int i, int j, List<String> list) {
        if (root.str != null) {
            list.add(root.str);
            root.str = null;
        }
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length) return;
        if (a[i][j] == '.') return;

        int ch = a[i][j] - 'a';
        if (root.ch[ch] == null) return;
        char tmp = a[i][j];
        a[i][j] = '.';
        root = root.ch[ch];
        dfs(root, a, i + 1, j, list);
        dfs(root, a, i - 1, j, list);
        dfs(root, a, i, j + 1, list);
        dfs(root, a, i, j - 1, list);
        a[i][j] = tmp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) insert(root, word);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                dfs(root, board, i, j, ans);
        return ans;
    }
}