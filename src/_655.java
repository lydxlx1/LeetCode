import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 655 - Print Binary Tree
 * <p>
 * DFS approach
 * <p>
 * Based on the problem description, let f(i) denote the width of the printed matrix w.r.t. the subtree rooted at i.
 * Then, we have
 * <p>
 * f(i) = max(f(i.left), f(i.right)) * 2 + 1, the problem requires that the left and the right subtree must have matrices in same size.
 * f(null) = 0
 * <p>
 * It is easy to see f(i) solves to f(i) = 2^f(height(i)) - 1.
 * So, if the final matrix has h rows, it will have 2^h - 1 columns.
 */
public class _655 {

    String[][] res;

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        int h = dfs(root);
        res = new String[h][(1 << h) - 1];
        for (String[] row : res) {
            Arrays.fill(row, "");
        }

        dfs(root, 0, 0, (1 << h) - 1 - 1);
        List<List<String>> list = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            list.add(Arrays.asList(res[i]));
        }
        return list;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(dfs(root.left), dfs(root.right)) + 1;
        }
    }

    /**
     * @param col1 - inclusive
     * @param col2 - inclusive
     */
    private void dfs(TreeNode root, int row, int col1, int col2) {
        if (root != null) {
            int mid = (col1 + col2) / 2;
            res[row][mid] = "" + root.val;
            dfs(root.left, row + 1, col1, mid - 1);
            dfs(root.right, row + 1, mid + 1, col2);
        }
    }

    public static void main(String[] args) {
        _655 sol = new _655();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);

        for (List<String> row : sol.printTree(a)) {
            System.out.println(row);
        }
    }
}