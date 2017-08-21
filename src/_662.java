import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 662 - Maximum Width of Binary Tree
 * <p>
 * DFS + Binary Tree Representation
 * <p>
 * Let the root have label 1.
 * For each node that has label x, the label of its left child is 2x, and the label of its right child is 2x + 1.
 * If x is not the root, the parent of x is floor(x / 2).
 * <p>
 * <p>
 * This code gets ACed by the OJ. However, the reader may notice that the labels in the algorithm can easily get
 * overflowed. I tried really hard to construct counter-examples but failed to do so...
 * I believe this just got lucky (maybe due to the overflow mechanism in 2s-complement representation).
 */
class _662 {

    List<Integer> min;
    List<Integer> max;

    private void dfs(TreeNode root, int d, int label) {
        if (root == null) {
            return;
        }

        if (d >= min.size()) {
            min.add(label);
            max.add(label);
        } else {
            min.set(d, Math.min(min.get(d), label));
            max.set(d, Math.max(max.get(d), label));
        }
        dfs(root.left, d + 1, 2 * label);
        dfs(root.right, d + 1, 2 * label + 1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        min = new ArrayList<>();
        max = new ArrayList<>();
        dfs(root, 0, 1);
        int ans = 0;
        for (int i = 0; i < min.size(); i++) {
            ans = Math.max(ans, max.get(i) - min.get(i) + 1);
        }
        return ans;
    }
}