import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 987 - Vertical Order Traversal of a Binary Tree
 *
 * DFS + Stream
 */
public class _987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> data = new ArrayList<>();
        dfs(root, 0, 0, data);
        return data.stream().collect(Collectors.groupingBy(a -> a[0])).entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey()))
                .map(entry -> entry.getValue().stream()
                        .sorted(Comparator.<int[]>comparingInt(a -> -a[1]).thenComparing(a -> a[2]))
                        .map(a -> a[2])
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toList());
    }

    private void dfs(TreeNode root, int x, int y, List<int[]> data) {
        if (root == null) {
            return;
        }
        data.add(new int[]{x, y, root.val});
        dfs(root.left, x - 1, y - 1, data);
        dfs(root.right, x + 1, y - 1, data);
    }
}

