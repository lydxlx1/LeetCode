import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 863 - All Nodes Distance K in Binary Tree
 * <p>
 * DFS
 */
public class _863 {

    Map<TreeNode, List<TreeNode>> g;
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        g = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);
        dfs1(target, null, 0, K);
        return res;
    }

    private void add(TreeNode a, TreeNode b) {
        g.putIfAbsent(a, new ArrayList<>());
        g.get(a).add(b);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        for (TreeNode child : new TreeNode[]{root.left, root.right}) {
            if (child != null) {
                add(root, child);
                add(child, root);
                dfs(child);
            }
        }
    }

    private void dfs1(TreeNode root, TreeNode parent, int d, int K) {
        if (root == null || d > K) {
            return;
        }
        if (d == K) {
            res.add(root.val);
        }
        for (TreeNode child : g.getOrDefault(root, new ArrayList<>())) {
            if (child != parent) {
                dfs1(child, root, d + 1, K);
            }
        }
    }
}

