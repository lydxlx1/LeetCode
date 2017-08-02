import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 642 - Design Search Autocomplete System
 * <p>
 * Trie
 */
public class _642_1 {


    Trie root = new Trie();
    String current = "";

    class Trie {
        Trie[] ch = new Trie[27];
        int freq = 0;
        String s = null;
        List<Trie> cand = new ArrayList<>(4);

    }

    private Trie insert(Trie root, int t, String s, int acc) {
        Trie leaf;
        if (t == s.length()) {
            root.s = s;
            root.freq += acc;
            leaf = root;
        } else {
            int ch;
            if (s.charAt(t) == ' ') ch = 26;
            else ch = s.charAt(t) - 'a';

            if (root.ch[ch] == null)
                root.ch[ch] = new Trie();
            leaf = insert(root.ch[ch], t + 1, s, acc);
        }

        if (!root.cand.contains(leaf)) {
            root.cand.add(leaf);
        }
        root.cand.sort(Comparator.<Trie>comparingInt(i -> i.freq).reversed().thenComparing(i -> i.s));
        if (root.cand.size() == 4)
            root.cand.remove(3);

        return leaf;
    }

    private List<String> dfs(Trie root, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            int ch;
            if (prefix.charAt(i) == ' ') ch = 26;
            else ch = prefix.charAt(i) - 'a';

            if (root.ch[ch] == null) return Collections.EMPTY_LIST;
            root = root.ch[ch];
        }
        return root.cand.stream().map(i -> i.s).collect(Collectors.toList());
    }

    public _642_1(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++)
            insert(root, 0, sentences[i], times[i]);
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(root, 0, current, 1);
            current = "";
            return Collections.EMPTY_LIST;
        } else {
            current += c;
            return dfs(root, current);
        }
    }

    public static void main(String[] args) {
        _642_1 sol = new _642_1(
                new String[]{"i love you", "island", "ironman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );
        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));

        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));

        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));


        System.out.println(sol.input('i'));
        System.out.println(sol.input(' '));
        System.out.println(sol.input('a'));
        System.out.println(sol.input('#'));
    }
}

