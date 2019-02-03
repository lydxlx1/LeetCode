/**
 * LeetCode 988 - Smallest String Starting from Leaf
 */
public class _988 {

    String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        ans = null;
        dfs(root, "");
        return ans;
    }

    void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }

        String ss = (char) (root.val + 'a') + s;
        if (root.left == null && root.right == null) {
            if (ans == null || ss.compareTo(ans) < 0) {
                ans = ss;
            }
        }
        dfs(root.left, ss);
        dfs(root.right, ss);
    }
}

