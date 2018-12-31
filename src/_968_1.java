import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode 968 - Binary Tree Cameras
 *
 * Greedy
 * 1. Placing a camera on a leaf is always no better than placing the camera on its parent, unless the leaf is the root.
 * 2. If a leaf is already covered by the camera on its parent, we can simply drop this leaf.
 *
 * We can keep applying 1 and 2 until the tree is exhausted.
 */
public class _968_1 {

    Map<TreeNode, TreeNode> parent;
    Map<TreeNode, Integer> degree;
    Set<TreeNode> hasCamera;
    Set<TreeNode> isCovered;

    public int minCameraCover(TreeNode root) {
        parent = new HashMap<>();
        degree = new HashMap<>();
        hasCamera = new HashSet<>();
        isCovered = new HashSet<>();

        dfs(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.addAll(degree.keySet().stream().filter(node -> degree.get(node) == 0).collect(Collectors.toList()));
        while (true) {
            TreeNode leaf = queue.poll();
            if (leaf == root) {
                return hasCamera.size() + (isCovered.contains(leaf) ? 0 : 1);
            }

            TreeNode p = parent.get(leaf);
            if (!isCovered.contains(leaf)) {
                hasCamera.add(p);
                // Here, we don't have to explicitly mark each of p's children.
                isCovered.add(p);
                isCovered.add(parent.get(p)); // Yes, parent.get(p) can be null, but it is okay...
            }

            if (degree.put(p, degree.get(p) - 1) == 1) {
                queue.add(p);
            }
        }
    }

    void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }

        if (p != null) {
            degree.put(p, degree.get(p) + 1);
        }
        parent.put(root, p);
        degree.put(root, 0);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}