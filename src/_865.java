/**
 * LeetCode 865 - Smallest Subtree with All the Deepest Nodes
 * <p>
 * Tree-DP
 */
public class _865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).subtreeAns;
    }

    class State {
        int subtreeHeight;
        TreeNode subtreeAns;
    }

    State dfs(TreeNode root) {
        State s = new State();
        s.subtreeHeight = 0;
        s.subtreeAns = root;

        for (TreeNode child : new TreeNode[]{root.left, root.right}) {
            if (child != null) {
                State ss = dfs(child);
                if (ss.subtreeHeight + 1 > s.subtreeHeight) {
                    s.subtreeHeight = ss.subtreeHeight + 1;
                    s.subtreeAns = ss.subtreeAns;
                } else if (ss.subtreeHeight + 1 == s.subtreeHeight) {
                    s.subtreeAns = root;
                }
            }
        }
        return s;
    }
}

