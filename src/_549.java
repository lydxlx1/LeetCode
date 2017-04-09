/**
 * LeetCode 549 - Binary Tree Longest Consecutive Sequence II
 * <p>
 * Tree-DP
 * For each node, maintain the length of the longest (downward) consecutively increasing/decreasing sequence.
 */
public class _549 {
    class Pair {
        final int incLen;
        final int decLen;

        public Pair(int incLen, int decLen) {
            this.incLen = incLen;
            this.decLen = decLen;
        }
    }

    int ans = 0;

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, 0);

        int inc = 1, dec = 1;
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (root.left != null) {
            int next = root.left.val;
            if (root.val + 1 == next) inc = Math.max(inc, 1 + left.incLen);
            if (root.val - 1 == next) dec = Math.max(dec, 1 + left.decLen);
        }
        if (root.right != null) {
            int next = root.right.val;
            if (root.val + 1 == next) inc = Math.max(inc, 1 + right.incLen);
            if (root.val - 1 == next) dec = Math.max(dec, 1 + right.decLen);
        }

        ans = Math.max(ans, inc + dec - 1);
        return new Pair(inc, dec);

    }

    public int longestConsecutive(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        _549 sol = new _549();
    }
}
