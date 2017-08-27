/**
 * LeetCode 666 - Path Sum IV
 * <p>
 * DFS approach
 * <p>
 * I have to admit that this is a STUPID and BORING problem.
 */
class _666 {
    int totalPathSum = 0;

    private int index(int[] tree, int d, int label) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] / 10 == d * 10 + label) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(int[] tree, int d, int label, int sum) {
        int i = index(tree, d, label);
        if (i == -1) {
            return;
        }

        sum += tree[i] % 10;
        if (index(tree, d + 1, 2 * label - 1) == -1 && index(tree, d + 1, 2 * label) == -1) {
            totalPathSum += sum;
        } else {
            dfs(tree, d + 1, 2 * label - 1, sum);
            dfs(tree, d + 1, 2 * label, sum);
        }
    }

    public int pathSum(int[] nums) {
        totalPathSum = 0;
        dfs(nums, 1, 1, 0);
        return totalPathSum;
    }
}