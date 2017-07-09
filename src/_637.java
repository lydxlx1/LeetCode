import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 637 - Average of Levels in Binary Tree
 * <p>
 * DFS
 */
public class _637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> value = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();

        class Solver {
            private void dfs(TreeNode root, int d) {
                if (root == null) return;
                if (value.size() == d) {
                    value.add(0.0);
                    cnt.add(0);
                }
                value.set(d, value.get(d) + root.val);
                cnt.set(d, cnt.get(d) + 1);

                dfs(root.left, d + 1);
                dfs(root.right, d + 1);
            }
        }
        new Solver().dfs(root, 0);

        for (int i = 0; i < value.size(); i++)
            value.set(i, value.get(i) / cnt.get(i));
        return value;
    }
}