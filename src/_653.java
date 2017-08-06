import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 653 - Two Sum IV - Input is a BST
 */
public class _653 {
    private List<Integer> nums = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }
}