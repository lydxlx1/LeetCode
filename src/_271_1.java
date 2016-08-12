import com.sun.media.sound.SoftTuning;

import java.util.*;

/**
 * LeetCode 271 - Encode and Decode Strings
 * <p>
 * Serialize and Deserialize a Trie
 * <p>
 * To maintain the list ordering, we prefix each string with its index (in fixed length) in the list.
 * Though the algorithm is correct, the constant is too large.
 */
public class _271_1 {

    static class Trie {
        Map<Integer, Trie> children = new HashMap<>();
        TreeSet<Integer> keys = new TreeSet<>();
        int cnt;
    }

    void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (!root.children.containsKey(ch)) {
                root.children.put(ch, new Trie());
                root.keys.add(ch);
            }
            root = root.children.get(ch);
        }
        root.cnt++;
    }

    void dfs(Trie root, StringJoiner joiner) {
        joiner.add(String.format("%d", root.cnt));
        for (int key : root.keys) joiner.add(String.format("%d", key));
        joiner.add("-1");
        for (int key : root.keys) dfs(root.children.get(key), joiner);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        Trie root = new Trie();
        for (int i = 0; i < strs.size(); i++)
            insert(root, String.format("%10d%s", i, strs.get(i)));  // need to maintain the vector order
        StringJoiner joiner = new StringJoiner(",");
        dfs(root, joiner);
        return joiner.toString();
    }

    Trie dfs(Deque<String> deque) {
        Trie root = new Trie();
        root.cnt = Integer.parseInt(deque.pollFirst());
        for (int key = Integer.parseInt(deque.pollFirst()); key != -1; key = Integer.parseInt(deque.pollFirst()))
            root.keys.add(key);
        for (int key : root.keys) root.children.put(key, dfs(deque));
        return root;
    }

    void collect(Trie root, int len, StringBuilder builder, List<String> list) {
        if (root.cnt > 0) {
            String s = builder.toString().substring(10); // skip the dummy prefix index
            for (int i = 0; i < root.cnt; i++) list.add(s);
        }
        for (int key : root.keys) {
            builder.append((char) key);
            collect(root.children.get(key), len + 1, builder, list);
            builder.deleteCharAt(len);
        }
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        Trie root = dfs(new ArrayDeque<>(Arrays.asList(s.split(","))));
        collect(root, 0, new StringBuilder(), res);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));