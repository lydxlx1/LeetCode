import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * LeetCode 314 - Binary Tree Vertical Order Traversal
 *
 * O(n) BFS approach
 *
 * This approach avoids using any collections (except for outputting the result) and thus is extremely fast.
 */
public class _314 {

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n;

    private void dfs(TreeNode root, int id) {
        if (id < min) min = id;
        if (id > max) max = id;
        n++;
        if (root.left != null) dfs(root.left, id - 1);
        if (root.right != null) dfs(root.right, id + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        n = 0;
        dfs(root, 0);
        List<List<Integer>> ans = new ArrayList<>(max - min + 1);
        for (int i = 0; i < max - min + 1; i++) ans.add(new ArrayList<>());

        TreeNode[] queueNode = new TreeNode[n];
        int[] queueId = new int[n];
        int head = 0, tail = 1;
        queueNode[0] = root;
        queueId[0] = 0;
        while (head < tail) {
            root = queueNode[head];
            int id = queueId[head++];
            ans.get(id - min).add(root.val);
            if (root.left != null) {
                queueNode[tail] = root.left;
                queueId[tail++] = id - 1;
            }
            if (root.right != null) {
                queueNode[tail] = root.right;
                queueId[tail++] = id + 1;
            }
        }
        return ans;
    }


}