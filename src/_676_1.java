/**
 * LeetCode 676 - Implement Magic Dictionary
 * <p>
 * Trie + Fuzzy search
 */
class _676_1 {

    static class Trie {
        boolean flag;
        Trie[] ch = new Trie[26];
    }


    Trie root;

    /**
     * Initialize your data structure here.
     */
    public _676_1() {
        root = new Trie();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            insert(root, word);
        }
    }

    private void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (root.ch[ch] == null) {
                root.ch[ch] = new Trie();
            }
            root = root.ch[ch];
        }
        root.flag = true;
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }

    private boolean dfs(Trie root, String word, int t, int mismatch) {
        if (root == null || mismatch > 1) {
            return false;
        }
        if (t == word.length()) {
            return root.flag && mismatch == 1;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            int delta = i == word.charAt(t) ? 0 : 1;
            if (dfs(root.ch[i - 'a'], word, t + 1, mismatch + delta)) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */