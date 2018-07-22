import java.util.ArrayList;
import java.util.List;


/**
 * LeetCode 872 - Leaf-Similar Trees
 * <p>
 * DFS
 */
public class _872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        dfs(root1, s1);
        dfs(root2, s2);
        return s1.equals(s2);
    }

    private void dfs(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            seq.add(root.val);
        }
        dfs(root.left, seq);
        dfs(root.right, seq);
    }
}

