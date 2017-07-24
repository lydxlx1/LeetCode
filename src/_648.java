import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * LeetCode 648 - Replace Words
 * <p>
 * Trie
 */
public class _648 {
    class Trie {
        Trie[] ch = new Trie[26];
        String s = null;
    }

    private void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.ch[ch] == null)
                root.ch[ch] = new Trie();
            root = root.ch[ch];
        }
        root.s = s;
    }

    private String search(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.s != null) {
                return root.s;
            }

            if (root.ch[ch] != null) {
                root = root.ch[ch];
            } else {
                break;
            }
        }
        return s; // return s no matter whether matches or not, as they produce the same output.
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie root = new Trie();
        for (String s : dict)
            insert(root, s);
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : sentence.split("[ ]+"))
            joiner.add(search(root, word));
        return joiner.toString();
    }

    public static void main(String[] args) {
        _648 sol = new _648();
        System.out.println(sol.replaceWords(Arrays.asList(
                "cat",
                "bat",
                "rat"
        ), "the cattle was rattled by the battery"));
    }
}