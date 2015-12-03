import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 310 - Minimum Height Trees
 *
 * Alternatively, one can solve this problem directly by tree dp.
 * Let dp[i] be the height of the tree when the tree root is i.
 * We compute dp[0] ... dp[n - 1] by tree dp in a dfs manner.
 *
 * Arbitrarily pick a node, say node 0, as the root, and do a dfs.
 * When reach a node u, and let T be the subtree by removing all u's descendant (see the right figure below).
 * We maintain a variable acc that keeps track of the length of the longest path in T with one endpoint being u.
 * Then dp[u] = max(height[u], acc)
 * Note, acc is 0 for the root of the tree.
 *
 *                 |                 |
 *                 .                 .
 *                /|\               /|\
 *               * u *             * u *
 *                /|\
 *               / | \
 *              *  v  *
 *
 *  . denotes a single node, and * denotes a subtree (possibly empty).
 *
 *  Now it remains to calculate the new acc for any of u's child, v.
 *  It is easy to see that the new acc is the max of the following
 *
 *  1) acc + 1 --- extend the previous path by the edge uv;
 *  2) max(height[v'] + 2), where v != v' --- see below for an example.
 *
 *                 u
 *                /|
 *               / |
 *              v' v
 *              |
 *              .
 *              .
 *              .
 *              |
 *              .
 *
 * In fact, the second case can be computed in O(1) time instead of spending a time proportional to the degree of u.
 * Otherwise, the runtime can be quadratic when the degree of some node is Omega(n).
 * The trick here is to maintain two heights of each node, the largest height (the conventional height), and the second largest height
 * (the height of the node after removing the branch w.r.t. the largest height).
 *
 * Therefore, after the dfs, all dp[i]'s are computed, and the problem can be answered trivially.
 * The total runtime is still O(n).
 */
public class _310_1 {
    int n;
    List<Integer>[] e;
    int[] height1;
    int[] height2;
    int[] dp;

    private void dfs(int u, int parent) {
        height1[u] = height2[u] = -Integer.MIN_VALUE / 10;
        for (int v : e[u])
            if (v != parent) {
                dfs(v, u);
                int tmp = height1[v] + 1;
                if (tmp > height1[u]) {
                    height2[u] = height1[u];
                    height1[u] = tmp;
                } else if (tmp > height2[u]) {
                    height2[u] = tmp;
                }
            }
        height1[u] = Math.max(height1[u], 0); // in case u is a leaf.
    }

    private void dfs(int u, int parent, int acc) {
        dp[u] = Math.max(height1[u], acc);
        for (int v : e[u])
            if (v != parent) {
                int newAcc = Math.max(acc + 1, (height1[v] + 1 == height1[u] ? height2[u] : height1[u]) + 1);
                dfs(v, u, newAcc);
            }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList(0);

        this.n = n;
        e = new List[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }

        height1 = new int[n];
        height2 = new int[n];
        dp = new int[n];

        dfs(0, -1);
        dfs(0, -1, 0);

        int min = dp[0];
        for (int i : dp)
            if (i < min) min = i;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (dp[i] == min) ans.add(i);
        return ans;
    }
}
