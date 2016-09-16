import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 272 - Closest Binary Search Tree Value II
 *
 * O(h + k) time & space
 *
 * Find the node with the smallest absolute difference, then keep calling predecessor and successor on either side.
 * Parent pointers are created on the fly while walking down level the tree.
 * To avoid parent pointers, Morris Traversal can be applied, which I am not willing to do. :)
 */
public class _272 {
    private Map<TreeNode, TreeNode> map;

    private TreeNode pred(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            for (root = root.left; root.right != null; map.put(root.right, root), root = root.right) ;
            return root;
        } else {
            while (map.get(root) != null && map.get(root).left == root) root = map.get(root);
            return map.get(root);
        }
    }

    private TreeNode succ(TreeNode root) {
        if (root.right != null) {
            map.put(root.right, root);
            for (root = root.right; root.left != null; map.put(root.left, root), root = root.left) ;
            return root;
        } else {
            while (map.get(root) != null && map.get(root).right == root) root = map.get(root);
            return map.get(root);
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        map = new HashMap<>();
        map.put(root, null);
        List<Integer> ans = new ArrayList<>();
        TreeNode split = root;
        for (TreeNode u = root; u != null; ) {
            if (Math.abs(u.val - target) < Math.abs(split.val - target)) split = u;
            TreeNode next = target < u.val ? u.left : u.right;
            map.put(next, u);
            u = next;
        }
        ans.add(split.val);
        TreeNode left = pred(split), right = succ(split);
        for (k--; k > 0; k--)
            if (left == null || (right != null && Math.abs(right.val - target) < Math.abs(left.val - target))) {
                ans.add(right.val);
                right = succ(right);
            } else {
                ans.add(left.val);
                left = pred(left);
            }
        return ans;
    }
}