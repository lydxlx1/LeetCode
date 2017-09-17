/**
 * LeetCode 677 - Map Sum Pairs
 * <p>
 * Trie
 */
class _677 {

    class Trie {
        int val;
        int sum; // sum of val's in the subtree
        Trie[] ch = new Trie[26];

        public void recompute() {
            sum = val;
            for (Trie i : ch)
                if (i != null) {
                    sum += i.sum;
                }
        }
    }

    Trie root;

    /**
     * Initialize your data structure here.
     */
    public _677() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        insert(root, key, 0, val);
    }

    public int sum(String prefix) {
        Trie r = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (r.ch[ch] == null) {
                return 0;
            }
            r = r.ch[ch];
        }
        return r.sum;
    }

    private void insert(Trie root, String s, int t, int val) {
        if (t == s.length()) {
            root.val = val;
        } else {
            int ch = s.charAt(t) - 'a';
            if (root.ch[ch] == null) {
                root.ch[ch] = new Trie();
            }
            root = root.ch[ch];

            insert(root, s, t + 1, val);
        }
        root.recompute();
    }

    public static void main(String[] args) {
        _677 sol = new _677();
        sol.insert("apple", 3);
        System.out.println(sol.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */