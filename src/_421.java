/**
 * LeetCode 421 - Maximum XOR of Two Numbers in an Array
 * <p>
 * Application of Binary Trie
 */
public class _421 {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        for (int i = 30; i >= 0; i--) {
            int ch = ((1 << i) & num) == 0 ? 0 : 1;
            if (root.child[ch] == null) root.child[ch] = new TrieNode();
            root = root.child[ch];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i : nums) insert(root, i);
        int ans = 0;
        for (int i : nums) {
            int tmp = 0;
            TrieNode r = root;
            for (int j = 30; j >= 0; j--) {
                int ch = ((1 << j) & i) == 0 ? 1 : 0;
                if (r.child[ch] != null) {
                    tmp |= 1 << j;
                    r = r.child[ch];
                } else {
                    r = r.child[ch ^ 1];
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}