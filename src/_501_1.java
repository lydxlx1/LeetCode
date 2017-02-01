import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 501 - Find Mode in Binary Search Tree
 * <p>
 * O(1)-extra-space solution
 */
public class _501_1 {
    private int maxFrequency, currentFrequency;
    TreeNode predecessor = null;

    public int[] findMode(TreeNode root) {
        reset();
        findMaxFrequency(root);

        reset();
        List<Integer> modes = new ArrayList<>();
        findModes(root, modes);

        return modes.stream().mapToInt(u -> u).toArray();
    }

    private void reset() {
        currentFrequency = 0;
        predecessor = null;
    }

    private void findMaxFrequency(TreeNode root) {
        if (root == null) return;

        findMaxFrequency(root.left);

        if (predecessor != null && predecessor.val == root.val) currentFrequency++;
        else currentFrequency = 1;
        maxFrequency = Math.max(maxFrequency, currentFrequency);
        predecessor = root;

        findMaxFrequency(root.right);
    }

    private void findModes(TreeNode root, List<Integer> list) {
        if (root == null) return;

        findModes(root.left, list);

        if (predecessor != null && predecessor.val == root.val) currentFrequency++;
        else currentFrequency = 1;
        if (currentFrequency == maxFrequency) list.add(root.val);
        predecessor = root;

        findModes(root.right, list);
    }
}

