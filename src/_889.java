/**
 * LeetCode 889 - Construct Binary Tree from Preorder and Postorder Traversal
 * <p>
 * DP
 * This solution does not put any assumption on the data.
 */
public class _889 {

    int[] pre, post;
    int n;
    TreeNode[][][] f;
    TreeNode error = new TreeNode(0);


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        this.n = pre.length;
        f = new TreeNode[n + 1][n][n];
        return dfs(n, 0, 0);
    }

    TreeNode dfs(int m, int i, int j) {
        if (m == 0) return null;
        if (pre[i] != post[j + m - 1]) return error;
        if (f[m][i][j] != null) return f[m][i][j];

        TreeNode res = new TreeNode(pre[i]);
        if (m > 1) {
            for (int leftSize = 0; leftSize <= m - 1; leftSize++) {
                int rightSize = m - 1 - leftSize;
                TreeNode left = dfs(leftSize, i + 1, j);
                TreeNode right = dfs(rightSize, i + 1 + leftSize, j + leftSize);
                if (left != error && right != error) {
                    res.left = left;
                    res.right = right;
                    break;
                }
            }
        }

        f[m][i][j] = res;
        return res;
    }
}

