import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1032 - Stream of Characters
 *
 * Trie
 */
public class _1032 {

    class Trie {
        boolean is;
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

    Trie root = new Trie();
    List<Integer> query = new ArrayList<>();

    public _1032(String[] words) {
        for (String word : words) {
            insert(root, (new StringBuilder(word)).reverse().toString());
        }
    }

    public boolean query(char letter) {
        query.add(letter - 'a');
        Trie node = root;
        for (int i = query.size() - 1; i >= 0; i--) {
            int ch = query.get(i);
            if (node.ch[ch] == null) {
                return false;
            }
            node = node.ch[ch];
            if (node.is) {
                return true;
            }
        }
        return false;
    }
}