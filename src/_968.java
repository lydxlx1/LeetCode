import java.util.stream.Stream;

/**
 * LeetCode 968 - Binary Tree Cameras
 *
 * Tree-DP
 */
public class _968 {

    int n;
    int[] f;
    int inf = 1 << 29;

    public int minCameraCover(TreeNode root) {
        n = 0;
        indexNode(root);
        f = new int[4 * n];
        return dfs(root, false, true);
    }

    void indexNode(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val = n++;
        indexNode(root.left);
        indexNode(root.right);
    }

    int dfs(TreeNode root, boolean itselfOk, boolean parentOk) {
        if (root == null) {
            return parentOk ? 0 : inf;
        }

        int key = root.val * 4 + (itselfOk ? 2 : 0) + (parentOk ? 1 : 0);
        if (f[key] > 0) {
            return f[key];
        }

        // Case 1: put a camera on the current node
        int ans = 1 + dfs(root.left, true, true) + dfs(root.right, true, true);

        // Case 2: When the parent is already covered, it is okay not to put a camera on the current node and delegate
        // the camera located from either its parent or one of its immediate children.
        if (parentOk) {
            TreeNode[] children = Stream.of(root.left, root.right).filter(i -> i != null).toArray(TreeNode[]::new);
            int total = 0;
            for (TreeNode child : children) {
                total += dfs(child, false, true); // Assume the current node is already covered by some child or the parent.
            }
            if (itselfOk) {
                ans = Math.min(ans, total);
            } else {
                for (TreeNode child : children) {
                    int tmp = total;
                    tmp -= dfs(child, false, true); // Exclude the cost that was incorrectly computed above.
                    tmp += dfs(child, false, false); // This is the true cost, where the current node (or parent of child) is not covered.
                    ans = Math.min(ans, tmp);
                }
            }
        }

        f[key] = ans;
        return ans;
    }
}

