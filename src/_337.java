/**
 * LeetCode 337 - House Robber III
 *
 * Tree DP
 *
 * Let x be some node in the tree.
 * We define x[0] and x[1] as the maximum amount of money the thief can rob
 * for the subtree rooted at x when x can be robbed and definitely cannot, respectively.
 *
 * How to compute x[0]?
 * We have two choices, i.e., 1) rob node x and 2) don't rob node x.
 * If it is the former, we get x.val money, but we cannot rob x's immediate children, namely, x.left and x.right.
 * Therefore, we can get at most x.val + x.left[1] + x.right[1] amount of money.
 * If it is the latter, we simply skip x and there is no constraint on its children, so x.left[0] + x.right[0] money.
 * Thus, x[0] = max(x.val + x.left[1] + x.right[1], x.left[0] + x.right[0]) since we always want to maximize the profit.
 *
 * How to compute x[1]?
 * This is just the case 2 of x[0].
 * x[1] = x.left[0] + x.right[0]
 *
 * For the boundary case, if x is null, then x[0] = x[1] = 0.
 *
 * The final answer is clearly root[0].
 * All the calculations can be done by a simple DFS, and therefore, the total runtime is O(n).
 */
public class _337 {
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[]{Math.max(l[0] + r[0], root.val + l[1] + r[1]), l[0] + r[0]};
    }

    public int rob(TreeNode root) {
        return dfs(root)[0];
    }
}