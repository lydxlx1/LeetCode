/**
 * LeetCode 255 - Verify Preorder Sequence in Binary Search Tree
 *
 * RMQ + Binary Search
 * O(n log n)
 *
 * Naturally, one can come up with a simple recursive algorithm shown as follows:
 * 1. partition the preorder array into three parts
 *    [root] [ < root ] [ > root ], where the last two parts can be empty.
 * 2. if there are more than three parts above, the preorder sequence is definitely invalid.
 * 3. recursively verify the second and third part.
 *
 * If we do step 1 by a simple linear scan, this method can have O(n^2) worst case complexity
 * when the tree is degenerated as a chain.
 *
 * To further speed it up, we can use binary search plus a Range Minimum/Maximum Query data structure
 * built on preorder array. Then, step 1 can be done in O(log n) time, and therefore,
 * the overall runtime is improved to O(n log n).
 */
public class _255_1 {
    int m;
    int[] preorder;
    int[][] min, max;

    private int max(int i, int j) {
        int hehe = (int) Math.floor(Math.log(j - i + 1) / Math.log(2));
        return Math.max(max[hehe][i], max[hehe][j - (1 << hehe) + 1]);
    }

    private int min(int i, int j) {
        int hehe = (int) Math.floor(Math.log(j - i + 1) / Math.log(2));
        return Math.min(min[hehe][i], min[hehe][j - (1 << hehe) + 1]);
    }

    private boolean dfs(int left, int right) {
        if (left >= right) return true;
        // We partition preorder[left .. right] into three parts
        // 1. preorder[left] --- root
        // 2. preorder[left+1 .. par] --- left branch
        // 3. preorder[par+1 .. right] --- right branch
        int par = left; // Assume left branch does not exist
        if (preorder[left + 1] < preorder[left]) {
            int i = left + 1, j = right + 1;
            while (i + 1 < j) {
                int mid = (i + j) / 2;
                if (preorder[mid] < preorder[left]) i = mid;
                else j = mid;
            }
            par = i;
        }
        if (left + 1 <= par && max(left + 1, par) > preorder[left]) return false;
        if (par + 1 <= right && min(par + 1, right) < preorder[left]) return false;

        return dfs(left + 1, par) && dfs(par + 1, right);
    }

    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) return true;
        int n = preorder.length;
        this.preorder = preorder;
        m = (int) (Math.log(n) / Math.log(2)) + 2;
        min = new int[m][n];
        max = new int[m][n];
        // init RMQ dp table
        for (int i = 0; i < n; i++) min[0][i] = max[0][i] = preorder[i];
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++) {
                min[i][j] = min[i - 1][j];
                max[i][j] = max[i - 1][j];
                if ((j + (1 << (i - 1))) < n) {
                    min[i][j] = Math.min(min[i][j], min[i - 1][j + (1 << (i - 1))]);
                    max[i][j] = Math.max(max[i][j], max[i - 1][j + (1 << (i - 1))]);
                }
            }
        return dfs(0, n - 1);
    }
}