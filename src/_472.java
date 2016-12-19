import java.util.*;

/**
 * LeetCode 472 - Concatenated Words
 * <p>
 * DP + Trie
 */
public class _472 {
    static class Trie {
        Trie[] ch = new Trie[26];
        String s = null;
    }

    Trie root = null;
    Set<String> set;
    Map<String, Boolean> map;

    private void insert(String s) {
        Trie r = root;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (r.ch[ch] == null) r.ch[ch] = new Trie();
            r = r.ch[ch];
        }
        r.s = s;
    }

    private boolean f(String s) {
        if (map.containsKey(s)) return map.get(s);
        boolean isok = false;

        Trie r = root;
        for (int i = 0; i < s.length() - 1; i++) {
            int ch = s.charAt(i) - 'a';
            if (r.ch[ch] != null) {
                r = r.ch[ch];
                if (r.s != null) {
                    String suffix = s.substring(i + 1);
                    if (set.contains(suffix) || f(suffix)) {
                        isok = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        map.put(s, isok);
        return isok;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        map = new HashMap<>();
        root = new Trie();
        for (String word : words)
            if (!word.equals("")) {
                set.add(word);
                insert(word);
            }

        List<String> ans = new ArrayList<>();
        for (String s : set)
            if (f(s)) ans.add(s);
        return ans;
    }
}