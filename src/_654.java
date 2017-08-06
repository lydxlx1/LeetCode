import java.util.Arrays;

/**
 * LeetCode 654 - Maximum Binary Tree
 * <p>
 * DFS approach
 */
public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, max));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, max + 1, nums.length));
        return root;
    }
}