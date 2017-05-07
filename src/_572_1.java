import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 572 - Subtree of Another Tree
 * <p>
 * O(n) solution
 * <p>
 * We only need to check those subtrees in s that has size equal to the size of t.
 * Also, no need to further search any children of those subtrees.
 */
public class _572_1 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Map<TreeNode, Integer> sMap = new HashMap<>();
        Map<TreeNode, Integer> tMap = new HashMap<>();
        getSize(s, sMap);
        getSize(t, tMap);
        return dfs(s, t, sMap, tMap);
    }

    private int getSize(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        map.put(root, getSize(root.left, map) + getSize(root.right, map) + 1);
        return map.get(root);
    }

    private boolean dfs(TreeNode s, TreeNode t, Map<TreeNode, Integer> sMap, Map<TreeNode, Integer> tMap) {
        if (sMap.get(s).equals(tMap.get(t))) // must use equals method since no unboxing is performed here.
            return isSame(s, t);
        if (s.left != null && dfs(s.left, t, sMap, tMap))
            return true;
        if (s.right != null && dfs(s.right, t, sMap, tMap))
            return true;
        return false;
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null)
            return b == null;
        if (b == null)
            return a == null;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
