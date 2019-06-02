import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1065 - Index Pairs of a String
 *
 * Trie
 */
public class _1065 {

    class Trie {
        boolean is = false;
        Trie[] ch = new Trie[26];
    }

    void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.ch[ch] == null) {
                root.ch[ch] = new Trie();
            }
            root = root.ch[ch];
        }
        root.is = true;
    }

    public int[][] indexPairs(String text, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            insert(root, word);
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            Trie node = root;
            for (int j = i; j < text.length(); j++) {
                int ch = text.charAt(j) - 'a';
                if (node.ch[ch] == null) {
                    break;
                }

                node = node.ch[ch];
                if (node.is) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans.stream().toArray(int[][]::new);
    }
}
