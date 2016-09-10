import java.util.*;

/**
 * LeetCode 314 - Binary Tree Vertical Order Traversal
 *
 * Using TreeSet for shorter code
 */
public class _314_1 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Arrays.asList();

        TreeMap<Integer, List<Integer>> ans = new TreeMap<>();
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        q1.add(0);
        q2.add(root);
        while (!q1.isEmpty()) {
            int key = q1.poll();
            root = q2.poll();
            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(root.val);
            if (root.left != null) {
                q1.add(key - 1);
                q2.add(root.left);
            }
            if (root.right != null) {
                q1.add(key + 1);
                q2.add(root.right);
            }
        }
        return new ArrayList(ans.values());
    }
}