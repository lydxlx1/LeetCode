import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 958 - Check Completeness of a Binary Tree
 *
 * BFS
 */
public class _958 {

    public boolean isCompleteTree(TreeNode root) {
        Queue<Map.Entry<Integer, TreeNode>> queue = new ArrayDeque<>();
        queue.add(new AbstractMap.SimpleEntry<>(1, root));

        int preVal = -1;
        while (!queue.isEmpty()) {
            int val = queue.peek().getKey();
            TreeNode node = queue.poll().getValue();

            if (preVal != -1 && val != preVal + 1) {
                return false;
            }
            if (node.left != null) {
                queue.add(new AbstractMap.SimpleEntry<>(val * 2, node.left));
            }
            if (node.right != null) {
                queue.add(new AbstractMap.SimpleEntry<>(val * 2 + 1, node.right));
            }

            preVal = val;
        }
        return true;
    }
}

